import java.util.Arrays;
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] results = new int [n-k+1];
        for(int i=0;i<=n-k;i++){
            if(isConsecutive(nums,i,k)){
                results[i]=nums[i+k-1];
            }
            else{
                results[i]=-1;
            }
        }
        return results;
        
    }
    private static boolean isConsecutive(int[] nums,int start,int k){
        for(int i=start;i<start+k-1;i++){
            if(nums[i]+ 1 != nums[i+1]){
                return false;
            }
        }
        return true;
    }
    
}
