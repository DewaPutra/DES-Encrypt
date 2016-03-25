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
        String dev[] = c.devn(8, plain);
        System.out.print("Key: ");
        String key = in.nextLine();
        key = c.addNULL(c.toBit(key));
        String chipertext = "";
        String conv="";
        for (int i=0;i<dev.length;i++){
            int j=i+1;
            dev[i]=c.addNULL(c.toBit(dev[i]));
            System.out.println("plain "+j+" in bit: "+dev[i]+" "+dev[i].length());
            String chiper = c.DESen(dev[i], key);
            System.out.println("    chiper dev["+j+"]: "+chiper+" "+chiper.length());
            conv = c.convertChiper(chiper);
            System.out.println("    converted chiper dev["+j+"]: "+conv+" "+conv.length());
            String decrypt = c.DESde(chiper, key);
            System.out.println("    decrypt dev["+j+"]: "+decrypt+" "+decrypt.length());
            conv = c.convertChiper(decrypt);
            System.out.println("    converted decrypt dev["+j+"]: "+conv+" "+conv.length());
            chipertext+=conv;           
        }
        
    }    
    
}
