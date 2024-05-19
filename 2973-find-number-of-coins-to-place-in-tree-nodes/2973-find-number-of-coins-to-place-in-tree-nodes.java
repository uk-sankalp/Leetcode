class Solution {
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n=cost.length;
        long coins[]=new long[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        placeCoins(adj,coins,cost,0, -1);
        return coins;
    }
    int[]placeCoins(List<List<Integer>> adj, long[]coins, int[]cost,int ind, int par) {
        int[]max3;
        // store largest 3 positive numbers in the subtree at indices 0,1,2 & smallest negative 2 numbers at indices 4,5.
        // max product can be formed by largest 3 positive nums or 2 smallest negative & 1 largest.
        // store number of nodes in subtree at index 3
        if(cost[ind]>=0) max3 = new int[]{0,0,cost[ind],1, 0,0};
        else max3 = new int[]{0,0,0,1,0,cost[ind]};
        for(int child: adj.get(ind)) {
            if(child==par) continue;
            int[]ans = placeCoins(adj, coins,cost, child, ind);
            max3[3]+=ans[3];
            // find max 3 positive & min 2 negative among the 10 numbers(5 in ans & 5 in max3) & store in max3
            findAndReplaceMinMax(ans,max3);
        }
        if(max3[3]>2) {
            long prod = (long)max3[0]*(long)max3[1]*(long)max3[2];
            coins[ind]=prod>0?prod:0;
            long negProd = (long)max3[2]*(long)max3[4]*(long)max3[5];
            coins[ind]=negProd>coins[ind]?negProd:coins[ind];
        }else coins[ind]=1;
        return max3;
    }

    void findAndReplaceMinMax(int[]ans, int[]max3) {
// finding the largest 3 positive numbers
            for(int i=0;i<3;i++) {
                if(ans[i]>max3[0]) {
                    max3[0]=ans[i];
                    if(max3[0]>max3[1]) {
                        int temp = max3[1];
                        max3[1]=max3[0];
                        max3[0]=temp;
                        if(max3[1]>max3[2]) {
                        temp = max3[1];
                        max3[1]=max3[2];
                        max3[2]=temp;
                        }
                    }
                }
            }
// finding minimum 4 negative numbers
            for(int i=4;i<6;i++) {
                if(ans[i]<max3[4]) {
                    max3[4]=ans[i];
                    if(max3[5]>max3[4]) {
                        int temp = max3[5];
                        max3[5]=max3[4];
                        max3[4]=temp;
                    }
                }
            }

    }
}