class Solution {
    public int maximumDifference(int[] nums) {
        int max=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    int val=Math.abs(nums[i]-nums[j]);
                    max=Math.max(val,max);
                }
            }
        }
       return max; 
    }
}