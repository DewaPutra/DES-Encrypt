package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;

public class DESEncrypt {

    public static void main(String[] args) {
        for(int i=0;i<26;i++){
            Scanner in = new Scanner(System.in);
            String plain = new BigInteger(in.nextLine().getBytes()).toString(2);
            System.out.println(plain + " " + plain.length());
        }
        
    }
    
}
