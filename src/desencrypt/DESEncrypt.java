package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {
    
    
    public static void main(String[] args) {
        iDES c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
        String plain = in.nextLine();
        String dev[] = c.devn(8, plain);
        String key = in.nextLine();
//        plain = c.addNULL(c.toBit(plain));
        key = c.addNULL(c.toBit(key));
        String chipertext = "";
        for (int i=0;i<dev.length;i++){
//            int devLength=dev[i].length();
//            while (devLength<8) {
//                dev[i]+="0";
//                devLength++;
//            }
            dev[i]=c.addNULL(c.toBit(dev[i]));
            System.out.println(dev[i].length()+" "+key.length());
            String chiper = c.DES(dev[i], key);
            String conv = c.convertChiper(chiper);
            System.out.println("Convert : "+conv);
            chipertext+=conv;
            System.out.println("Chipertext : "+chipertext);
            
        }
//        System.out.println(plain.length()+" "+key.length());
        
        
    }    
    
}
