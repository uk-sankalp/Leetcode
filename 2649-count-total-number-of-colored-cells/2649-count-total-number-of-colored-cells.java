class Solution {
    public long coloredCells(int n) {
        if(n==1){
            return 1;
        }
        long ans=1;
        int k=4;
        for(int i=2;i<=n;i++){
            ans+=k;
            k+=4;
        }
        return ans;
    }
}