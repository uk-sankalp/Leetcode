class Solution {
    public int maxProfit(int[] prices) {
    //  -----------> Brute force Approach
    //     int maxprofit=0;
    //    for(int i=0;i<prices.length;i++){
    //     int min=10000;
    //     for(int j=i;j>=0;j--){
    //         if(prices[j]<min){
    //             min=prices[j];
    //         }
    //     }
    //     int profit=prices[i]-min;
    //     maxprofit=Math.max(maxprofit,profit);
    //    } 
    //    return maxprofit;

    // ------> Optimised Approach
    int maxprofit=0;
    int buyingp=10000;
    for(int i=0;i<prices.length;i++){
        if(prices[i]<buyingp){
            buyingp=prices[i];
        }
        else{
            maxprofit=Math.max(maxprofit,prices[i]-buyingp);
        }
    }
    return maxprofit;
    }
}