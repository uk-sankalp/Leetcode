class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n=x;
        int newname=0;
        while(x>0){
            int r=x%10;
            newname=newname*10+r;
            x/=10;
        }
        return newname==n;
    }
}