class Solution {
    public static void addValue(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<Integer> newList = new ArrayList<>();
            newList.add(value);
            map.put(key, newList);
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            addValue(map,nums[i],i);
        }
        for(Map.Entry<Integer,List<Integer>> it:map.entrySet()){
            List<Integer> value=it.getValue();
            if(value.size()>1){  
                int i=1;
                int ind=0;
                while(i<value.size()){
                    int a=value.get(ind);
                    int b=value.get(ind+1);
                    ind++;
                    i++;
                    if((Math.abs(a-b))<=k){
                    return true;
                   }
                }
            }
        }
        return false;
    }
}