class Solution {
    public static int[] getConcatenation(int[] nums) {
    int[] ans=new int[2*nums.length];
    int n=nums.length;
    for (int i = 0; i < nums.length; i++) {
        ans[i]=nums[i];
        ans[i+n]=nums[i];
    }
    return ans;
}
}