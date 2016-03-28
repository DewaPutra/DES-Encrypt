
package desencrypt;

import java.util.*;
import java.io.*;
import desencrypt.iDES;

public class CFB {
    
    public static String[] CFBEncrypt(String IV, String Key, String plaintext){
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
    
    public static String[] CFBDecrypt(String IV, String Key, String chipertext){
        iDES c = new iDESImplementation();        
        String chiper[]= c.devn(8, chipertext);
        String plain[]= new String[chiper.length];
        
        String init = c.toBit(IV);
        if(init.length()<64) init = c.addNULL(init);
        String key = c.toBit(Key);
        if(key.length()<64) key = c.addNULL(key);
        
        for(int i=0;i<chiper.length;i++){
            String p = c.toBit(chiper[i]);
            System.out.println(p.length());
            if(p.length()<64) p = c.addNULL(p);
            String desResult = c.DESen(init, key);
            plain[i]=c.XOR(desResult, p);
            init = p;
        }
        return plain;
    }
    
    public static void main(String[] args) {
        iDES c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
        String IV = "lkjh1a9g";
        String key = "asdfghjk";
        System.out.print("Message: ");
        String plain = in.nextLine();
        String finChip="";
        
        //Encrypting
        String cfbResult[] = CFBEncrypt(IV, key, plain);
        
        for(int i=0;i<cfbResult.length;i++){
            //int j=i+1;
            finChip += c.convertChiper(cfbResult[i]);
            String d8[] = c.devn(8, cfbResult[i]);
            System.out.println(cfbResult[i]);
            for(int j=0;j<d8.length;j++){
                System.out.println("Chiper8-bit: "+d8[j] +" "+ d8[j].length());
            }
        }
        System.out.println("Final Chiper: "+finChip +" "+ finChip.length());
    
        //Decrypting
        String cfbResultDecrypt[] = CFBDecrypt(IV, key, finChip);
        finChip = "";
        for(int i=0;i<cfbResultDecrypt.length;i++){
            int j=i+1;
            finChip += c.convertChiper(cfbResultDecrypt[i]);
        }
        System.out.println("Final Plain : "+finChip +" "+ finChip.length());
    }
}
