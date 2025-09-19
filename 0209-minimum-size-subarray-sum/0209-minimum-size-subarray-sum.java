class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum=0;
        while(j<nums.length){
            if(sum<target){
            sum+=nums[j];
            j++;
            }
            while(sum>=target){
                length=Math.min(length,j-i);
                sum-=nums[i];
                i++;
            }      
        }
        return length==Integer.MAX_VALUE?0:length;
    }
}