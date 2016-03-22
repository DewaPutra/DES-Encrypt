
package desencrypt;

import java.io.*;
import java.util.*;

public interface iDES {
    
    public String toBit(String plain);
    
    public String InP(String plain);
    
    public String addNULL(String plain);
    
    public String ExP(String plain);
    
    public String Permutation(String plain);
    
    public String[] dev8(String plain);
    
    public String FinP(String plain);
    
    public String PC2(String plain);
    
}
