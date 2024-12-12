class Solution {
    public static boolean isPalindrome(String s) {
    // StringBuilder sb=new StringBuilder();
    String s1=(s.replaceAll("[^a-zA-Z0-9]", "")).toLowerCase();
    int start=0;
    int end=s1.length()-1;
    while (start<end){
        if (s1.charAt(start) == s1.charAt(end)) {
            start++;
            end--;
        }
        else {
            return false;
        }
    }
    return true;
    }
}