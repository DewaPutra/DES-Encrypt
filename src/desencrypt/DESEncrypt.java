package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {
    
    public static String DES(String plain){
        iDESImplementation c = new iDESImplementation();
        String chiper="";
        
        return chiper;
    }

    public static void main(String[] args) {
        iDESImplementation c = new iDESImplementation();
        String[] string8 = new String[]{};
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        string8 = c.devn(6,inp);
        for(int i=0;i<string8.length;i++){
            System.out.println(string8[i]+" "+string8[i].length());
        }
    }    
    
    
}
