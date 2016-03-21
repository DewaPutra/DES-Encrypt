
package desencrypt;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class iDESImplementation implements iDES{

    public String toBit(String plain) {
        String temp = new BigInteger(plain.getBytes()).toString(2);
        String plaintext="0";
        int tempLength=temp.length();
        while (tempLength<7) {
            plaintext+="0";
            tempLength++;
        }
        plaintext+=temp;
        return plaintext;
    }

    public String IP(String plain) {
        String plainIP="";
        final int[] table = { 
            58, 50, 42, 34, 26, 18, 10, 2,
            60, 52, 44, 36, 28, 20, 12, 4,
            62, 54, 46, 38, 30, 22, 14, 6,
            64, 56, 48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17, 9,  1,
            59, 51, 43, 35, 27, 19, 11, 3,
            61, 53, 45, 37, 29, 21, 13, 5,
            63, 55, 47, 39, 31, 23, 15, 7
        };
        for(int i=0;i<table.length;i++){
            char temp = plain.charAt(table[i]-1);
            plainIP = plainIP+temp;
        }
        return plainIP;
    }
    
    public String addNULL(String plain) {
        String newPlain=plain;
        int temp= plain.length();
        while (temp<64){
            newPlain = newPlain+"0";
            temp = newPlain.length();
        }
        return newPlain;
    }
    
    public String EP(String plain) {
        String newPlain="";
        int [] table ={ 32, 1, 2, 3, 4, 5,
                        4 , 5, 6, 7, 8, 9,
                        8 , 9,10,11,12,13,
                        12,13,14,15,16,17,
                        16,17,18,19,20,21,
                        20,21,22,23,24,25,
                        24,25,26,27,28,29,
                        28,29,30,31,32,1 };
        for(int i=0;i<table.length;i++){
            char temp=plain.charAt(table[i]-1);
            newPlain=newPlain+temp;
        }
        return newPlain;
    }

    public String Permutation(String plain) {
        String newPlain="";
        
    }
    
    
    
}
