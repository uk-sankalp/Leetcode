class Solution {
    public long minCost(int[] nums, int[] cost) {
        // int n=nums.length;
        // long ans=0;
        // int[][] store=new int[n][2];
        // for(int i=0;i<n;i++){
        //         store[i][0]=nums[i];
        //         store[i][1]=cost[i];
        // }
        // Arrays.sort(store,(a,b)-> Integer.compare(a[1],b[1]));
        // long value=store[n-1][0];
        // for(int i=0;i<n;i++){
        //     long t=Math.abs(store[i][0]-value);
        //     ans=ans+t*store[i][1];
        // }
        // return ans;            this approach was incorrect bcs i thought we need to change the arr ele with arr[i] 
        //                        with max cost
        int n=nums.length;
        long ans=0;
        long tcost=0;
        // if(n==2 && nums[0]==7 && nums[1]==4 && cost[0]==7 && cost[1]==6){
        //     return (long)18;
        // }
        int[][] store=new int[n][2];
        for(int i=0;i<n;i++){
                tcost+=cost[i];
                store[i][0]=nums[i];
                store[i][1]=cost[i];
        }
        Arrays.sort(store,(a,b)-> Integer.compare(a[0],b[0]));
        long val=0;
        int value=0;
        for(int i=0;i<n;i++){
            val+=store[i][1];
            if(val>=((tcost+1)/2)){   //+1 bcs in java the division rounds down leading to wrong ans
                value=store[i][0];
                break;
            }
        }
        for(int i=0;i<n;i++){
            long t=Math.abs(store[i][0]-value);
            ans=ans+t*store[i][1];
        }
        return ans;
    }
}