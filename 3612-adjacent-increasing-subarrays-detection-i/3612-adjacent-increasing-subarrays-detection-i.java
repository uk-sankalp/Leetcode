class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1){
           return true;
        }
        for(int i=0;i<=nums.size()-2*k;i++){
            int count=0;
            for(int j=i+1;j<i+k;j++){
                if(nums.get(j)<=nums.get(j-1)){
                    break;
                }
                else{
                    count++;
                }
            }
            for(int j=i+k+1;j<i+2*k;j++){
                if(nums.get(j)<=nums.get(j-1)){
                    break;
                }
                else{
                    count++;
                }
            }
            if(count==2*(k-1)){
                return true;
            }
        }
        return false;
    }
}