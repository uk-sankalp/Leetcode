class Solution {
    public int minimumOperations(int[] nums) {
        int operation=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%3!=0){
                operation+=Math.min((nums[i]%3-0),(3-nums[i]%3));
            }
        }
        return operation;
    }
}