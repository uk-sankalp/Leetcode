class Solution {
    private static boolean isprime(int num){
        if(num<=1){
            return false;
        }
        if(num==2 || num==3){
            return true;
        }
        if(num%2==0){
            return false;
        }
        for(int i=3;i<=Math.sqrt(num);i=i+2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int[] ans={-1,-1};
        int mark1=-1;
        int mark2=-1;
        int val1=-1;
        int val2=-1;
        int mindiff=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(isprime(i)){
                mark1=mark2;
                mark2=i;
            }
            if(mark1>0){
                int curr=Math.abs(mark1-mark2);
                if(curr<mindiff){
                    mindiff=curr;
                    val1=mark1;
                   val2=mark2;
                }
                // mindiff=Math.min(mindiff,Math.abs(mark1-mark2));
                // if(mindiff<curr){
                // val1=mark1;
                // val2=mark2;
                }
                
            }
        if(val1>0 && val2>0){
        ans[0]=val1;
        ans[1]=val2;
        }
        return ans;
        }
}