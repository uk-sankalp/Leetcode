class Solution {
    public String triangleType(int[] nums) {
        for(int i=0;i<3;i++){
            if(nums[0]==nums[1] && nums[1]==nums[2]){
                return "equilateral";
            }
            else if(nums[0] + nums[1]<=nums[2] || nums[0] + nums[2] <=nums[1] || nums[1] + nums[2]<=nums[0]){
                return "none";
                }
            else if(nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2]){
                return "isosceles";
            }
            // else if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[0]!=nums[2]){
            //     if(nums[0] + nums[1]>nums[2] && nums[0] + nums[2] >nums[1] && nums[1] + nums[2]>nums[0]){
            //     return "scalene";
            //     }
            // }
        }
        return "scalene";
    }
}