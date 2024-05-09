class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int reduceFactor = 0, idx=happiness.length-1;
        Arrays.sort(happiness);
        while(k-->0) {
            if(idx < 0 || happiness[idx]-reduceFactor <= 0) break;
            ans += (long)(happiness[idx]-reduceFactor);
            reduceFactor++;
            idx--;
        }
        return ans;
    }
}