class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Better Solution ~ O(N^3) + O(log n)
        // List<List<Integer>> ans=new ArrayList<>();
        // Set<List<Integer>> set=new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> temp=new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }
        //         }
        //     }
        // }
        // for(List<Integer> item:set){
        //     ans.add(item);
        // }
        // return ans;

        //Better Solution ~ O(N^2) * O(log n) for hashseet
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer> hmap=new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                int val=-(nums[i]+nums[j]);
                if(hmap.containsKey(val)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(val);
                    Collections.sort(temp);
                    set.add(temp);
                }
                hmap.put(nums[j],0);
            }
        }
        for(List<Integer> item:set){
            ans.add(item);
        }
        return ans;
    }
}