package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;

public class DESEncrypt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String plain = new BigInteger(in.nextLine().getBytes()).toString(2);
        System.out.println(plain + " " + plain.length());
        System.out.println("64 I : "+ plain.substring(0, 63)+ " "+plain.substring(0, 63).length());
        System.out.println("64 II : "+ plain.substring(64, plain.length())+ " "+plain.substring(64, plain.length()).length());
    }
    
}
