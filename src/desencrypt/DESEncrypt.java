package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;

public class DESEncrypt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp = new BigInteger(in.nextLine().getBytes()).toString(2);
        String plain="0";
        int tempLength=temp.length();
        while (tempLength<7) {
            plain+="0";
            tempLength++;
        }
        plain+=temp;
        System.out.println(plain + " " + plain.length());
        
    }    
}
