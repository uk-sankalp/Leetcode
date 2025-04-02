class Solution {
    public long maximumTripletValue(int[] nums) {
        // long max=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             max=Math.max((long)(nums[i]-nums[j])*nums[k],max);
        //         }
        //     }
        // }
        // return max;  This is the basic brute force approach that every kiddo use
        long result=0;
        int maxab=0;
        int maxa=0;
        for(int val:nums){
            result=Math.max(result,(long) maxab* val);
            maxab=Math.max(maxab,maxa-val);
            maxa=Math.max(maxa,val);
        }
        return result;
    }
}