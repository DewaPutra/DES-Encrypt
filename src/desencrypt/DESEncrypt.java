package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {

    public static void main(String[] args) {
        iDESImplementation c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
        String plain = c.toBit(in.nextLine());
        
        System.out.println(plain + " " + plain.length());
        
    }
}
