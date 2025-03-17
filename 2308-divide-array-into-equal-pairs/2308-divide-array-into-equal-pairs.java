class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)%2 !=0){
                return false;
            }
        }
        return true;
    }
}