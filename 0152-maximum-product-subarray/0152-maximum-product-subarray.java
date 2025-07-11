class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct=Integer.MIN_VALUE;
        // int prod=1;
        int suff=1;
        int pref=1;
        for(int i=0;i<nums.length;i++){
            if(pref==0){
                pref=1;
            }
            if(suff==0){
                suff=1;
            }
            pref=pref*nums[i];
            suff=suff*nums[nums.length-1-i];
            maxproduct=Math.max(maxproduct,Math.max(pref,suff));
        }
        // for(int i=0;i<nums.length;i++){
        //     int product=1;
        //     for(int j=i;j<nums.length;j++){
        //         product*=nums[j];
        //         if(product>maxproduct){
        //             maxproduct=product;
        //         }
        //     }
        // }
        // return maxproduct;
        return maxproduct;
    }
}