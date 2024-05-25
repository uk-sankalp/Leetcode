class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        Arrays.fill(dp, "");

        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < cost.length; j++) {
                if(i < cost[j]) continue;
                if((i - cost[j]) == 0 || ((i - cost[j]) > 0 
                && !dp[i - cost[j]].equals("")))
                dp[i] = max(dp[i],(j+1) + dp[i - cost[j]]);
            }
        }

        return (dp[target].equals("") ? "0" : dp[target]);    
    }

    private String max(String a, String b) {
        if(a.length() > b.length()) return a;
        else if(b.length() > a.length()) return b;
        return a.compareTo(b) < 0 ? b : a;
    }
}
