class Solution {
   public  static int[] smallerNumbersThanCurrent(int[] nums) {
    int current=Integer.MAX_VALUE;
    int[] nums2=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            nums2[i]=count;
        }
        return nums2;
    }
}