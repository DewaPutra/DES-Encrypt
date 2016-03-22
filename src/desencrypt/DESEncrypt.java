package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {

    public static void main(String[] args) {
        iDESImplementation c = new iDESImplementation();
        String[] string8 = new String[]{};
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String in2 = in.nextLine();
        String out = c.XOR(input, in2);
        System.out.println(out+" "+ out.length());
        
    }
}
