class Solution {
    public long maximumTripletValue(int[] nums) {
        long res=0;
        int maxab=0;
        int maxa=0;
        for(int a:nums){
            res=Math.max(res,(long)maxab*a);
            maxab=Math.max(maxab,maxa-a);
            maxa=Math.max(maxa,a);
        }
        return res;
    }
}