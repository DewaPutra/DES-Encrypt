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
        
        int[][] S = {{1,2,3,4,5,6,7,8,9},{9,2,1,2,4,4,5,5}};
        System.out.println(S[0][1]);
    }
}
