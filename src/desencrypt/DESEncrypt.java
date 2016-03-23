package desencrypt;

import java.io.*;
import java.util.*;
import java.math.*;
import desencrypt.iDESImplementation;

public class DESEncrypt {

    public static void main(String[] args) {
        iDESImplementation c = new iDESImplementation();
//        String[] string8 = new String[]{};
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] string8 = new String[8];
        int counter8=1;
        int counterLength=0;
        int index=0;
        String temp="";
        while (counterLength<input.length()){
            temp+=input.substring(counterLength, counterLength+1);
            counterLength++;
            counter8++;
            int tempLength = input.length()-counterLength;
            if (counter8==9 || (tempLength<8 && counterLength==input.length())) {
                string8[index] = temp;
                counter8=1;
                index++;
                temp="";
            }
        }
        
        String plain="";
        //Kurang variable untuk nyimpen plain yang udah diubah
        for (int x=0;x<index;x++) {
            System.out.println(string8[x]);
            plain = c.toBit(string8[x]);
            System.out.println(plain + " " + plain.length());
        }
//        String in2 = in.nextLine();
//        String out = c.XOR(input, in2);
//        System.out.println(out+" "+ out.length());
        
        String newPlain =  c.Sbox(plain);
        System.out.println(newPlain + " " + newPlain.length());
    }

}
