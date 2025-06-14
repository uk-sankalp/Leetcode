class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j}; // the 2 indexes
                }
            }
        }
        return new int[]{}; 
    }
}
//this is the brute force solution
// This is the simplest approach n2
