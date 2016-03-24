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
        String key = in.nextLine();
        plain = c.addNULL(c.toBit(plain));
        key = c.addNULL(c.toBit(key));
        System.out.println(plain.length()+" "+key.length());
        String chiper = c.DES(plain, key);
        String conv = c.convertChiper(chiper);
        
    }    
    
}
