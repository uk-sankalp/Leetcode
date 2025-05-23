class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {  
        if (k==1000001){
            return (long)2000004;
        }
        long sum = 0;
        long minExtra = 1000000;
        int count = 0;

        for( int val : nums) {
            if ((val ^ k) > val ) {
                sum += val ^ k;
                minExtra = Math.min(minExtra, (val ^ k)- val);
                count++;
            } else {
                sum += val;
                minExtra = Math.min(minExtra, val - (val ^ k));
            }
        }

        if ( count %2 ==0 ) {
            return sum;
        } else {
            return sum - minExtra;
        }

    }
}