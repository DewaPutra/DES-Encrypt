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
    
//        String dev[]= c.devn(8, plain);
//        String conv="";
//        String chiperfix="", plainfix="";
//        for (int i=0;i<dev.length;i++){
//            dev[i]=c.addNULL(c.toBit(dev[i]));
//            String chiper = c.DESen(dev[i], key);
//            conv = c.convertChiper(chiper);
//            chiperfix+=conv;
//            String decrypt = c.DESde(chiper, key);
//            conv = c.convertChiper(decrypt);
//            plainfix+=conv;           
//        }     
//        System.out.println("Chiper: "+chiperfix+" Plain: "+plainfix);
    }    
    
}
