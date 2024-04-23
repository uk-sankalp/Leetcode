class Solution {
    public int[] runningSum(int[] nums) {
        int []  newnums= new int [nums.length];
        newnums[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            newnums[i]= newnums[i-1]+nums[i];
        }
        return  newnums;
        
    }
}