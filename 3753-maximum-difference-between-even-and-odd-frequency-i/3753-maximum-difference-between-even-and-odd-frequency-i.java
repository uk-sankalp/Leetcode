class Solution {
    public int maxDifference(String s) {
        int maxodd=Integer.MIN_VALUE;
        int mineven=Integer.MAX_VALUE;
        int [] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]>maxodd && freq[i]%2!=0){
                maxodd=freq[i];
            }
            if(freq[i]<mineven && freq[i]%2==0 && freq[i]!=0){
                mineven=freq[i];
            }
        }
        int ans=maxodd-mineven;
        return ans; 
    }
}