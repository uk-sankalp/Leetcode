class Solution {
   public static  int maxSubArray(int[] nums) {
    int maxsum=Integer.MIN_VALUE;
    int currentsum=0;
        for (int i = 0; i < nums.length; i++) {
            currentsum+=nums[i];
            if(maxsum<currentsum){
                maxsum=currentsum;
            }
            if(currentsum<0){
                currentsum=0;
            }
        }
        return maxsum;
    }
}