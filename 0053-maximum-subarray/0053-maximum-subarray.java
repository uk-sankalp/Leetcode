class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        if(maxsum==0){
            int high=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>high){
                    high=nums[i];
                }
            }
            return high;
        }
        return maxsum;
    }
}