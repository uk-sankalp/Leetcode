class Solution {
    public int countSubarrays(int[] nums, int k) {
        // 1. find index of k, and convert array into -1, 0, 1
        int idxK = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) nums[i] = -1;
            else if (nums[i] > k) nums[i] = 1;
            else {
                idxK = i;
                nums[i] = 0;
            }
        }
        // 2. calculate the prefix Sum
        int[] prefixSum = new int[nums.length + 1];
        
        for (int i = 1; i < prefixSum.length; i++) prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        
        // 3. calculate three range: total [0, n - 1]  - left[0, idxK - 1] - right[idxK + 1];
        int left = helper(0, idxK, prefixSum);
        int right = helper(idxK + 1, nums.length, prefixSum);
        int total = helper( 0, nums.length, prefixSum);
        
        return total - left - right;
    }
    
    // calculate current interval, subarray sum = 0 and 1;
    private int helper(int l, int r, int[] prefixSum) {
        Map<Integer, Integer> counter = new HashMap<>();
        
        int ans = 0;
        for (int i = l; i <= r; i++) {
            int currSum = prefixSum[i];
            
            if (counter.containsKey(currSum)) {
                ans += counter.get(currSum);
            }
            
            if (counter.containsKey(currSum - 1)) {
                ans += counter.get(currSum - 1);
            }
            
            counter.put(currSum, counter.getOrDefault(currSum, 0) + 1);
        }

        return ans;
    }
}