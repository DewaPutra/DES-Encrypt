
package desencrypt;

import java.io.*;
import java.util.*;

public interface iDES {
    
    String toBit(String plain);
    
    String IP(String plain);
    
    String addNULL(String plain);
    
    String EP(String plain);
    
    String Permutation(String plain);
    
}
