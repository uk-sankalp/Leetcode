class Solution {
   public static boolean isPalindrome(String s) {
        String news=(s.replaceAll("[^a-zA-Z0-9]","")).toLowerCase();
        int st=0;
        int e=news.length()-1;
        return palindrome(news,st,e);
    }
    public static boolean palindrome(String news,int st,int e){
        if(st>=e){
            return true;
        }
        if(news.charAt(st)!=news.charAt(e)){
            return false;
        }
        return palindrome(news,st+1,e-1);
    }
}