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
        String iv="", plain="", key="s3rvf1l3";
            key = c.toBit(key);
            String dev[]= c.devn(8, "adder(2,5)");
            String conv="";
            String chiperfix="", plainfix="";
            for (int i=0;i<dev.length;i++){
                dev[i]=c.addNULL(c.toBit(dev[i]));
                String chiper = c.DESen(dev[i], key);
                iv+=chiper;
                System.out.println(chiper+" "+ chiper.length());
                conv = c.convertChiper(chiper);
                chiperfix+=conv;
                String decrypt = c.DESde(chiper, key);
                conv = c.convertChiper(decrypt);
                plainfix+=conv;           
            
            }
            System.out.println(plainfix);
            System.out.println(iv.length());
    }    
}
