package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {
    
    
    public static void main(String[] args) throws IOException {
        
        iDES c = new iDESImplementation();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("E:\\ITS\\KULIAH\\SEMESTER 6\\KIJ\\DESEncrypt\\datasetcoba.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
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
        
        
        
        //more than 8-bit plain and 8-bit key
//        for (int i=0;i<dev.length;i++){
//            int j=i+1;
//            dev[i]=c.addNULL(c.toBit(dev[i]));
//            System.out.println("plain "+j+" in bit: "+dev[i]+" "+dev[i].length());
//            String chiper = c.DESen(dev[i], key);
//            System.out.println("    chiper dev["+j+"]: "+chiper+" "+chiper.length());
//            conv = c.convertChiper(chiper);
//            System.out.println("    converted chiper dev["+j+"]: "+conv+" "+conv.length());
//            String decrypt = c.DESde(chiper, key);
//            System.out.println("    decrypt dev["+j+"]: "+decrypt+" "+decrypt.length());
//            conv = c.convertChiper(decrypt);
//            System.out.println("    converted decrypt dev["+j+"]: "+conv+" "+conv.length());
//            chipertext+=conv;           
//        }     
    }    
    
}
