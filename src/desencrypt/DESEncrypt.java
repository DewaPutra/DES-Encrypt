package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {

    public static void main(String[] args) {
        iDESImplementation c = new iDESImplementation();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] string8 = new String[]{""};
        int counter8=1;
        int counterLength=0;
        int index=0;
        String temp="";
        while (counterLength<input.length()){
            temp+=input.substring(counterLength, counterLength+1);
            counterLength++;
            counter8++;
            if (counter8==9) {
//                string8[index] = temp;
                System.out.println(temp);
                counter8=1;
                index++;
                temp="";
            }
        }
        
//        for (int x=0;x<index-1;x++) {
//            System.out.println(string8[x]);
//        }
        
//        String plain = c.toBit();
//        
//        System.out.println(plain + " " + plain.length());
        
    }
}
