
package desencrypt;

import java.util.*;
import java.io.*;
import desencrypt.iDES;

public class CFB {
    
    public static String[] CFBmain(String IV, String Key, String plaintext){
        iDES c = new iDESImplementation();
        String plain[]= c.devn(8, plaintext);
        String chiper[]= new String[plain.length];
        String init = c.toBit(IV);
        if(init.length()<64) init=c.addNULL(init);
        String key = c.toBit(Key);
        if(key.length()<64) key = c.addNULL(key);
        
        for(int i=0;i<plain.length;i++){
            String p = c.toBit(plain[i]);
            if(p.length()<64) p=c.addNULL(p);
            String desResult = c.DESen(init, key);
            init = c.XOR(desResult, p);
            chiper[i]=init;
        }
        return chiper;
    }
    
    public static String[] CFBmainDecrypt(String IV, String Key, String plaintext){
        iDES c = new iDESImplementation();        
        String plain[]= c.devn(8, plaintext);
        String chiper[]= new String[plain.length];
        
        String init = c.toBit(IV);
        if(init.length()<64) init = c.addNULL(init);
        String key = c.toBit(Key);
        if(key.length()<64) key = c.addNULL(key);
        
        for(int i=0;i<plain.length;i++){
            String p = c.toBit(plain[i]);
            if(p.length()<64) p = c.addNULL(p);
            String desResult = c.DESde(init, key);
            chiper[i]=c.XOR(desResult, p);
            init = p;
        }
        return chiper;
    }
    
    public static void main(String[] args) {
        iDES c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
//        System.out.print("IV: ");
//        String IV = in.nextLine();
//        System.out.print("Key: ");
//        String key = in.nextLine();
        String IV = "lkjh1a9g";
        String key = "asdfghjk";
        System.out.print("Message: ");
        String plain = in.nextLine();
        String finChip="";
        
        //Encrypting
        String cfbResult[] = CFBmain(IV, key, plain);
        for(int i=0;i<cfbResult.length;i++){
            int j=i+1;
            System.out.println(j+" "+cfbResult[i]+" "+cfbResult[i].length());
            finChip += c.convertChiper(cfbResult[i]);
        }
        System.out.println("Final Chiper: "+finChip +" "+ finChip.length());
    
        //Decrypting
        String cfbResultDecrypt[] = CFBmainDecrypt(IV, key, finChip);
        finChip = "";
        for(int i=0;i<cfbResultDecrypt.length;i++){
            int j=i+1;
            System.out.println(j+" "+cfbResultDecrypt[i]+" "+cfbResultDecrypt[i].length());
//            System.out.println("  "+c.convertChiper(cfbResult[i])
            finChip += c.convertChiper(cfbResultDecrypt[i]);
        }
        System.out.println("Final Plain : "+finChip +" "+ finChip.length());
    }
}
