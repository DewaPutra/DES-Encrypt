package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {
    
    
    public static void main(String[] args) {
        
        iDES c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
        System.out.print("Plaintext: ");
        String plain = in.nextLine();
        System.out.print("Key: ");
        String key = in.nextLine();
        key = c.addNULL(c.toBit(key));
        
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
