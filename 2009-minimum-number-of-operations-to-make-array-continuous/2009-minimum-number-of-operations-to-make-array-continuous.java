class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the input array in ascending order
        int m = 1;
        
        // Remove duplicate elements in the sorted array
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        
        int ans = n;
        
        // Use a sliding window to find the minimum number of operations
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < m && nums[j] - nums[i] <= n - 1) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }
        
        return ans;
    }
}
