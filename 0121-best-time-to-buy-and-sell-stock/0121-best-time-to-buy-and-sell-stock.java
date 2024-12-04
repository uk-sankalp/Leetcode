class Solution {
public int maxProfit(int[] prices) {
    int buy=Integer.MAX_VALUE;
    int max_profit=0;
    for(int i=0;i<prices.length;i++){
        if(buy<prices[i]){
            int profit=prices[i]-buy;
            max_profit=Math.max(max_profit,profit);
        }
        else{
            buy=prices[i];
        }
    }
    return max_profit;
  }
}




















// class Solution {
//     public int maxProfit(int[] prices) {
//         int max=Integer.MIN_VALUE;
//         int profit=0;
//         for(int i=0;i<prices.length;i++){
//             for(int j=i+1;j<prices.length;j++){
//                 profit=prices[j]-prices[i];
//                 max=Math.max(profit,max);
//             }
//         }
//         if(max<0){
//             max=0;
//         }
//         return max;
//     }
// }