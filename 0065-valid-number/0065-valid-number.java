// Patter maching concept:
// **Number Validation:**
//  Pattern:[+-]?((\\d+)|((\\d+\\.)|(\\d+\\.\\d+)|(\\.\\d+)))(e[+-]?\\d+)?
 
//  Program:
 import java.util.*;
import java.util.regex.*;
class Solution {
    public boolean isNumber(String s) {
    s=s.toLowerCase();
     Pattern p=Pattern.compile("[+-]?((\\d+)|((\\d+\\.)|(\\d+\\.\\d+)|(\\.\\d+)))(e[+-]?\\d+)?");
     Matcher m=p.matcher(s);
     boolean b=m.matches();
     if(b)
        {
            return true;
        }
        return false;
    }
}