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
        String[] string8 = new String[]{};
        int counter8=1;
        int counterLength=0;
        int index=0;
        while (counterLength<input.length()){
            
            counterLength++;
            counter8++;
            if (counter8==9) {
                counter8=1;
                index++;
            }            
        }
        string8 = c.dev8(input);
        for(int i=0;i<string8.length;i++){
            System.out.println(string8[i]+" "+string8[i].length());
        }
        
    }
}
