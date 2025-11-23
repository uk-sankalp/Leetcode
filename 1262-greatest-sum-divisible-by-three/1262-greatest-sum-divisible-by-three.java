class Solution {
        public int maxSumDivThree(int[] A) {
        int[] dp = new int[3];
        for (int a : A)
            for (int i: Arrays.copyOf(dp, dp.length))
                dp[(i + a) % 3] = Math.max(dp[(i + a) % 3], i + a);
        return dp[0];
    }
}