class Solution {
    public static int waysToSplitArray(int[] nums) {
        int count=0;
        long total=0;
        long current=0;
        for (int i :nums) {
            total+=i;
        }
        for (int i = 0; i < nums.length-1; i++) {
        current+=nums[i];
        if(current>=(total-current)){
            count++;
        }
        }
        return count;
    }
}