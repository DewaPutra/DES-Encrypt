
package desencrypt;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class iDESImplementation implements iDES{

    public String toBit(String plain) {
        String temp = new BigInteger(plain.getBytes()).toString(2);
        String plaintext="";
        int tempLength=temp.length();
        while (tempLength<8) {
            plaintext+="0";
            tempLength++;
        }
        plaintext+=temp;
        return plaintext;
    }
    
}
