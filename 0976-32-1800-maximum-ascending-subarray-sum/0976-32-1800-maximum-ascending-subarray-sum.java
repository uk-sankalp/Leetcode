class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=0;
        int curr=0;
        curr+=nums[0];
        if(nums.length==1){
            return nums[0];
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                curr+=nums[i];
            }
            else{
                max=Math.max(curr,max);
                curr=0;
                curr+=nums[i];
            }
            max=Math.max(curr,max);
    }
    return max;
  }
}