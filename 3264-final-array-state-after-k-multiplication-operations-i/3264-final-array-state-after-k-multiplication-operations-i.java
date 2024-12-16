class Solution {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
    class Helper{
        int minimum(int[] nums){
            int min=Integer.MAX_VALUE;
            int index=0;
            for (int i = nums.length-1; i >=0 ; i--) {
                if(nums[i]<=min){
                    min=nums[i];
                    index=i;
                }
            }
            return index;
        }
    }
    Helper helper=new Helper();
        for (int i = 0; i < k; i++) {
        int index=helper.minimum(nums);
        nums[index]=nums[index]*multiplier;
        }
        return nums;
    }
}