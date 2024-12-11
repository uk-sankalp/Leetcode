class Solution {
   public static  int maxSubArray(int[] nums) {
    int max_sum=Integer.MIN_VALUE;
        int max_neg=Integer.MIN_VALUE;
        int current=0;
        boolean allnegative=true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max_neg){
                max_neg=nums[i];
            }
            if(nums[i]>0){
                allnegative=false;
                break;
            }
        }
        if(allnegative){
            return max_neg;
        }
        for (int i = 0; i < nums.length; i++) {
            current+=nums[i];
            if(current<0){
                current=0;
            }
            max_sum=Math.max(current,max_sum);
            }
        return max_sum;
    }
}