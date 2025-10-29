class Solution {
    public int smallestNumber(int n) {
        int count=0;
        int i=0;
        while(count<n){
            count+=Math.pow(2,i);
            i++;
        }
        return count;
    }
}