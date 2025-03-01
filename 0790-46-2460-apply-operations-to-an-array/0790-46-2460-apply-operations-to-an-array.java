import java.util.*;
class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int index=0;
        for(int n:nums){
            if(n!=0){
                nums[index++]=n;
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }
    return nums;
    }    
}


// return list.stream().mapToInt(i -> i).toArray();