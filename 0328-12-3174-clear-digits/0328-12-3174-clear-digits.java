import java.util.*;
class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                if (!stack.isEmpty()){
                stack.pop();
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        int n=stack.size();
        for(int i=n-1;i>=0;i--){
             if (!stack.isEmpty()){
                char c=stack.pop();
                sb.insert(0,c);
                }
                         
        }
    return sb.toString();      
    }
}