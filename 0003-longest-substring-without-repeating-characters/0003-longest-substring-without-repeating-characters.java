class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        int i=0;
        int j=0;
        Set<Character> set=new HashSet<>();
        while(j<s.length()){
            char ch=s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
                length=Math.max(length,j-i);
            }
            else{
                set.remove(ch);
                while(i<s.length() && s.charAt(i)!=s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
        return length;
    }
}