
package desencrypt;

import java.util.*;
import java.io.*;
import desencrypt.iDES;

public class CFB {
    
    public static String[] CFBmain(String IV, String Key, String plaintext){
        iDES c = new iDESImplementation();
        int t= plaintext.length()/8;
        int t1 = plaintext.length()%8;
        if(t1>0) t++;
        String chiper[]= new String[t];
        String plain[]= c.devn(8, plaintext);
        String init = c.toBit(IV);
        if(init.length()<64) init=c.addNULL(init);
        String key = c.toBit(Key);
        if(key.length()<64) key = c.addNULL(key);
        
        for(int i=0;i<t;i++){
            String p = c.toBit(plain[i]);
            if(p.length()<64) p=c.addNULL(p);
            String desResult = c.DES(init, key);
            init = c.XOR(desResult, p);
            chiper[i]=init;
        }
        return chiper;
    }
    
    public static void main(String[] args) {
        iDES c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
        System.out.print("IV: ");
        String IV = in.nextLine();
        System.out.print("Key: ");
        String key = in.nextLine();
        System.out.print("Message: ");
        String plain = in.nextLine();
        
        String cfbResult[] = CFBmain(IV, key, plain);
        for(int i=0;i<cfbResult.length;i++){
            int j=i+1;
            System.out.println(j+" "+cfbResult[i]+" "+cfbResult[i].length());
            System.out.println("  "+c.convertChiper(cfbResult[i]));
        }
    }
}
