class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // int maxsum=0;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     HashSet<Integer> set=new HashSet<>();
        //     for(int j=i;j<nums.length;j++){
        //         if(!set.contains(nums[j])){
        //             set.add(nums[j]);
        //             sum+=nums[j];
        //         }
        //         else{
        //             break;
        //         }
        //     }
        //     maxsum=Math.max(maxsum,sum);
        // }
        // return maxsum;

        //--------> Optimised Version
        HashSet<Integer> set=new HashSet<>();
        int left=0;
        int max=0;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            set.add(nums[right]);
            sum+=nums[right];
            max=Math.max(max,sum);
        }
        return max;
    }
}