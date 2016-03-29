
package desencrypt;

import static desencrypt.DESEncrypt.dataset;
import java.util.*;
import java.io.*;
import desencrypt.iDES;

public class CFB {
    
    public static int lineCounter(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
    
    public static String[] dataset(String path) throws IOException{
        int len = lineCounter(path);
        String d[] = new String[len];
        BufferedReader br = null;
        try {
            String sCurrentLine;
            int now=0, idx=0;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                d[idx]=sCurrentLine;
                idx+=1;
            }
	} catch (IOException e) {
            e.printStackTrace();
	} finally {
            try {
		if (br != null)br.close();
            } catch (IOException ex) {
		ex.printStackTrace();
            }
	}
        return d;
    }
    
    public static String[] CFBEncrypt(String IV, String Key, String plaintext){
        iDES c = new iDESImplementation();
        String plain[]= c.devn(8, plaintext);
        String chiper[]= new String[plain.length];
        
        String init = c.toBit(IV);
        if(init.length()<64) init=c.addNULL(init);
        String key = c.toBit(Key);
        if(key.length()<64) key = c.addNULL(key);
        
        for(int i=0;i<plain.length;i++){
            String p = c.toBit(plain[i]);
            if(p.length()<64) p=c.addNULL(p);
            String desResult = c.DESen(init, key);
            init = c.XOR(desResult, p);
            chiper[i]=init;
        }
        return chiper;
    }
    
    public static String[] CFBDecrypt(String IV, String Key, String chipertext){
        iDES c = new iDESImplementation();        
        String chiper[]= c.devn(64, chipertext);
        String plain[]= new String[chiper.length];
        
        String init = c.toBit(IV);
        if(init.length()<64) init = c.addNULL(init);
        String key = c.toBit(Key);
        if(key.length()<64) key = c.addNULL(key);
        
        for(int i=0;i<chiper.length;i++){
            String p=chiper[i];
            if(p.length()<64) p = c.addNULL(p);
            String desResult = c.DESen(init, key);
            plain[i]=c.XOR(desResult, p);
            init = p;
        }
        return plain;
    }
    
    public static void main(String[] args) throws IOException{
        iDES c = new iDESImplementation();
        String path = "E:\\ITS\\KULIAH\\SEMESTER 6\\KIJ\\DESEncrypt\\datasetcoba.txt";
        String d[] = dataset(path);
        String IV = "", key = "", plain="";
        String finChip="";
        
        for(int k=0;k<d.length;k+=3){
            int j=k;
            IV=d[j];
            key=d[j+1];
            plain=d[j+2];
            key = c.toBit(key);
            
            //Encrypting
            String cfbResult[] = CFBEncrypt(IV, key, plain);
            String finChipBit = "";
            finChip="";
            for(int i=0;i<cfbResult.length;i++){
                finChipBit+=cfbResult[i];
                finChip += c.convertChiper(cfbResult[i]);
                String d8[] = c.devn(8, cfbResult[i]);
            }
            System.out.println("Final Chiper: "+finChip +" "+ finChip.length());

            //Decrypting
            String cfbResultDecrypt[] = CFBDecrypt(IV, key, finChipBit);
            finChip = "";
            for(int i=0;i<cfbResultDecrypt.length;i++){
                finChip += c.convertChiper(cfbResultDecrypt[i]);
            }
            System.out.println("Final Plain : "+finChip +" "+ finChip.length());
        }
    }
}
