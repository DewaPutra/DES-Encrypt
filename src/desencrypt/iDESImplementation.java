
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
    
    public String InP(String plain) {
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
    
    public String ExP(String plain) {
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
        int table[] ={ 16,  7, 20, 21, 29, 12, 28, 17,
                        1, 15, 23, 26,	5, 18, 31, 10,
                        2,  8, 24, 14, 32, 27,	3,  9,
                       19, 13, 30,  6, 22, 11,	4, 25};
        
        for(int i=0;i<table.length;i++){
            char temp = plain.charAt(table[i]);
            newPlain = newPlain+temp;
        }
        return newPlain;
    }

    public String[] devn(int n, String plain) {
        int idx = 0;
        int temp=plain.length()/n, temp2 = plain.length()%n;
        if(temp2>0) temp+=1;
        String newPlain[] =  new String[temp];
        int begin=0, end=8;
        for(int i=0;i<temp;i++){
            newPlain[idx]=plain.substring(begin, end);
            begin = end;
            end = end+8;
            if (end>plain.length()) end=plain.length();
            idx++;
        }
        return newPlain;
    }

    public String FinP(String plain) { 
        String newPlain="";
        int table[]={40, 8, 48,	16, 56,	24, 64,	32,
                     39, 7, 47,	15, 55,	23, 63,	31,
                     38, 6, 46,	14, 54,	22, 62,	30,
                     37, 5, 45,	13, 53,	21, 61,	29,
                     36, 4, 44,	12, 52,	20, 60,	28,
                     35, 3, 43,	11, 51,	19, 59,	27,
                     34, 2, 42,	10, 50,	18, 58,	26,
                     33, 1, 41,	9,  49,	17, 57,	25};
        for(int i=0;i<table.length;i++){
            char temp = plain.charAt(table[i]);
            newPlain = newPlain+temp;
        }
        return newPlain;
        
    }

    public String PC2(String plain) {
       String newPlain="";
       int table[] ={14, 17, 11, 24,  1,  5,
                      3, 28, 15,  6, 21, 10,
                     23, 19, 12,  4, 26,  8,
                     16,  7, 27, 20, 13,  2,
                     41, 52, 31, 37, 47, 55,
                     30, 40, 51, 45, 33, 48,
                     44, 49, 39, 56, 34, 53,
                     46, 42, 50, 36, 29, 32};
       for(int i=0;i<table.length;i++){
            char temp = plain.charAt(table[i]);
            newPlain = newPlain+temp;
        }
       return newPlain;
    }

    public String PC1(String plain) {
        String newPlain="";
        int tableLeft[] = {57, 49, 41, 33, 25, 17,  9,
                            1, 58, 50, 42, 34, 26, 18,
                           10,  2, 59, 51, 43, 35, 27,
                           19, 11,  3, 60, 52, 44, 36};
        int tableRight[] ={63, 55, 47, 39, 31, 23, 15,
                            7, 62, 54, 46, 38, 30, 22,
                           14,  6, 61, 53, 45, 37, 29,
                           21, 13,  5, 28, 20, 12, 4};
        for(int i=0;i<tableLeft.length;i++){
            char temp = plain.charAt(tableLeft[i]);
            newPlain = newPlain+temp;
        }
        for(int i=tableLeft.length;i<tableRight.length+tableLeft.length;i++){
            char temp = plain.charAt(tableRight[i]);
            newPlain = newPlain+temp;
        }
        return newPlain;
    }

    public String leftShift(int idx, String plain) {
        String newPlain=plain;
        for(int i=0;i<idx;i++){
            newPlain = newPlain.substring(1, newPlain.length())+newPlain.charAt(0);
        }
        return newPlain;
    }

    public String XOR(String plain, String key) {
        String newPlain="";
        char temp, temp1, temp2;
        for( int i=0; i<plain.length() ; i++)
        {
            temp = plain.charAt(i);
            temp1 = key.charAt(i);
            if(temp==temp1) {
                temp2='0';
            } else temp2='1';
            newPlain+=temp2;
        }
        return newPlain;
    }

    public String Sbox(String plain) {
        String newPlain="";
        String dev6[] = devn(6,plain);
        for(int i=0;i<dev6.length;i++){
            
        }
        return newPlain;
    }
   
}

