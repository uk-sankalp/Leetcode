class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        int times=n/2;
        int rem=n%2;
        if(rem==0){
            int temp=1;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    ans[i]=temp;
                }
                else{
                    ans[i]=temp*-1;
                    temp++;
                }
            }
        }
        else{
            int temp=1;
            ans[0]=0;
            for(int i=1;i<n;i++){
                 if(i%2!=0){
                    ans[i]=temp;
                }
                else{
                    ans[i]=temp*-1;
                    temp++;
                }
            }

        }
        return ans;
    }
}