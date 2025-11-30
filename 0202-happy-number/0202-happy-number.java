class Solution {
    public boolean isHappy(int n) {
        int value=0;
        while(value!=1 && n!=4){
            while(n>0){
                int r=n%10;
                n/=10;
                value+=r*r;
            }
            if(value==1){
                return true;
            }
            n=value;
            value=0;
        }
        return false;
    }
}