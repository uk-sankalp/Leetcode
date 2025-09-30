class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        while(n>1){
            int[] newNum=new int[n-1];
            for(int i=0;i<newNum.length;i++){
                newNum[i]=(nums[i]+nums[i+1])%10;
            }
            for(int i=0;i<newNum.length;i++){
                nums[i]=newNum[i];
            }
            n--;
        }
        return nums[0];
    }
}