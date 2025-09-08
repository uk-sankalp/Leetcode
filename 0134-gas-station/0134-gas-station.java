class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0;
        int total=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }
        return total>=0?start:-1;
        // Brute Force
        // int n=gas.length;
        // for(int i=0;i<n;i++){
        //     int tank=0;
        //     int count=0;
        //     int j=i;
        //     while(count<n){
        //         tank+=gas[j]-cost[j];
        //         if(tank<0){
        //             break;
        //         }
        //         j=(j+1)%n;
        //         count++;
        //     }
        //     if(count==n){
        //         return i;
        //     }
        // }
        // return -1;
        // -2 -2 -2 3 3
    }
}