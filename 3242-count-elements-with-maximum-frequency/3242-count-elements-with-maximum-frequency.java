class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>count){
                count=map.get(num);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value=entry.getValue();
            if(value==count){
                max+=value;
            }
        }
        return max;
    }
}