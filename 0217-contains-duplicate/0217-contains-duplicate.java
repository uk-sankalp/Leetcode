class Solution {
   public  static boolean containsDuplicate(int[] nums) {

        // for (int j = 0; j < nums.length; j++) {
        //     for (int i = 0; i < nums.length-1; i++) {
        //         if(nums[i]<nums[i+1]){
        //             int temp=nums[i];
        //             nums[i]=nums[i+1];
        //             nums[i+1]=temp;
        //         }
        //     }
        // } this will result in exponential time complexity so we can use inbuilt java sorting method which is Arrays.sort
       Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}