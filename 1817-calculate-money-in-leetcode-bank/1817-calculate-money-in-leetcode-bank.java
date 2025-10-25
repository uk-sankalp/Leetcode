class Solution {
    public int totalMoney(int n) {
        int money=0;
        int init=0;
        int total=0;
        for(int i=1;i<=n;i++){
            int day=i%7;
            if(day==1){
                init++;
                money=init;
            }
            else{
                money++;
            }
            total+=money;
        }
        return total;
    }
}