class Solution {
    private int mod=(int)1e9+7;
    public int numWays(String[] words, String target) {
        int charsAtInd[][]=new int[words[0].length()][26];
        for(int j=0;j<words[0].length();j++){
            for(String w:words)    charsAtInd[j][w.charAt(j)-'a']++;
        }
        return (int)get_ans(words,0,0,target,charsAtInd,new Long[words[0].length()][target.length()]);
    }
    private long get_ans(String []words,int i,int j,String target,int charsAtInd[][],Long [][]dp){
        if(j==target.length() || words[0].length()-i-1<target.length()-j-1)     
            return j==target.length()?1:0;
        if(dp[i][j]!=null)  return dp[i][j];
        long ways=get_ans(words,i+1,j,target,charsAtInd,dp);
        if(charsAtInd[i][target.charAt(j)-'a']>0)     
            ways=(ways+(charsAtInd[i][target.charAt(j)-'a']*get_ans(words,i+1,j+1,target,charsAtInd,dp))%mod)%mod;
        return dp[i][j]=ways;
    }
}