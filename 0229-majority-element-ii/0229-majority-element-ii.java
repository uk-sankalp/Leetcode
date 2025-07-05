class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int times=(int)Math.floor(nums.length/3);
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=ele2){
                count1=1;
                ele1=nums[i];
            }
            else if(count2==0 && nums[i]!=ele1){
                count2=1;
                ele2=nums[i];
            }
            else if(nums[i]== ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int c1=0;
        int c2=0;
        for(int val:nums){
            if(val==ele1){
                c1++;
            }
            else if(val==ele2){
                c2++;
            }
        }
        if(c1>times){
            list.add(ele1);
        }
        if(c2>times){
            list.add(ele2);
        }
        return list;
    }
}