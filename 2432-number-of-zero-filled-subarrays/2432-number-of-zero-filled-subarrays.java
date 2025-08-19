class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                temp++;
            }
            else{
                count+=(temp*(temp+1L))/2L;
                temp=0;
            }
        }
        count+=(temp*(temp+1))/2L;
        return count;
    }
}