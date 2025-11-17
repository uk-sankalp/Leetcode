class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int current=-1;
        int last=-1;
        for(int i=0;i<nums.length;i++){
            if(current==-1 && last==-1 && nums[i]==1){
                current=i;
                last=i;
            }
            else if(nums[i]==1){
                current=i;
                if((current-last-1)<k){
                    return false;
                }
                last=current;
            }
        }
        return true;
    }
}