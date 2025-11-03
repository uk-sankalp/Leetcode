// class Solution {
//     public static boolean isPalindrome(String st){
//         int i=0;
//         int j=st.length()-1;
//         while(i<j){
//             if(st.charAt(i)!=st.charAt(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public String longestPalindrome(String s) {
//         if(s.length()==1){
//             return s;
//         }
//         HashSet<String> set=new HashSet<>();
//         for(int i=0;i<s.length();i++){
//             for(int j=s.length()-1;j>i;j--){
//                 if(s.charAt(i)==s.charAt(j)){
//                     String st=s.substring(i,j+1);
//                     if(isPalindrome(st)){
//                         set.add(st);
//                     }
//                 }
//             }
//         }
//         if(set.size()==0){
//             return String.valueOf(s.charAt(0));
//         }
//         String largest = "";
//         for (String start : set) {
//             if (start.length() > largest.length()) {
//                 largest = start;
//             }
//         }
//         return largest;
//     }
// }
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}