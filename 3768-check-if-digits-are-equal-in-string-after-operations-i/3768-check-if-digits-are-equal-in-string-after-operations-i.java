class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
        StringBuilder sb=new StringBuilder();
           for(int i=0;i<s.length()-1;i++) {
            char ch=s.charAt(i);
            char ch2=s.charAt(i+1);
            int sum=(Character.getNumericValue(ch)+Character.getNumericValue(ch2))%10;
            sb.append(sum);
           }
           s=sb.toString();
        }
        return s.charAt(0)==s.charAt(1); 
    }
}