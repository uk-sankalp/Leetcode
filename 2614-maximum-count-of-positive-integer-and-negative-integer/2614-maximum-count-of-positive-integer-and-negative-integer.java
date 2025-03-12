class Solution {
    public int maximumCount(int[] nums) {
        int pos=0;
        int neg=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                neg+=1;
            }
            if(nums[i]>0){
                pos+=1;
            }
        }
        return Math.max(neg,pos);
    }
}