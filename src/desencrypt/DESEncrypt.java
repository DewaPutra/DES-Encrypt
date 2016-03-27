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
        
        //simple 8-bit plain and key
        String chipertext = c.DESen(c.addNULL(c.toBit(plain)), key);
        String conv=c.convertChiper(chipertext);
        System.out.println("Chipertext: "+conv);
        String plaintext = c.DESde(chipertext, key);
        conv=c.convertChiper(plaintext);
        System.out.println("Plaintext: "+conv);
        
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
