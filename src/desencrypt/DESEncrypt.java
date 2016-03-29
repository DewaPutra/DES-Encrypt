package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {
    
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
    
    
    public static void main(String[] args) throws IOException {
        
        iDES c = new iDESImplementation();
        String path ="E:\\ITS\\KULIAH\\SEMESTER 6\\KIJ\\DESEncrypt\\datasetcoba.txt";
        String d[] = dataset(path);
        String iv="", plain="", key="";
        for(int k=0;k<d.length;k+=3){
            int j=k;
            iv=d[j];
            key=d[j+1];
            plain=d[j+2];
            key = c.toBit(key);
            String dev[]= c.devn(8, plain);
            String conv="";
            String chiperfix="", plainfix="";
            for (int i=0;i<dev.length;i++){
                dev[i]=c.addNULL(c.toBit(dev[i]));
                String chiper = c.DESen(dev[i], key);
                conv = c.convertChiper(chiper);
                chiperfix+=conv;
                String decrypt = c.DESde(chiper, key);
                conv = c.convertChiper(decrypt);
                plainfix+=conv;           
            }     
            System.out.println("Chiper: "+chiperfix+" Plain: "+plainfix);
        }
    }    
}
