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
        // List<List<Integer>> ans=new ArrayList<>();
        // Set<List<Integer>> set=new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     HashMap<Integer,Integer> hmap=new HashMap<>();
        //     for(int j=i+1;j<nums.length;j++){
        //         int val=-(nums[i]+nums[j]);
        //         if(hmap.containsKey(val)){
        //             List<Integer> temp=new ArrayList<>();
        //             temp.add(nums[i]);
        //             temp.add(nums[j]);
        //             temp.add(val);
        //             Collections.sort(temp);
        //             set.add(temp);
        //         }
        //         hmap.put(nums[j],0);
        //     }
        // }
        // for(List<Integer> item:set){
        //     ans.add(item);
        // }
        // return ans;

    // Optimal Approach
    Arrays.sort(nums);
    List<List<Integer>> ans=new ArrayList<>();
    for(int i=0;i<nums.length;i++){
        if(i!=0 && nums[i]==nums[i-1]){
            continue;
        }
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
            int sum=nums[i]+nums[j]+nums[k];
            if(sum==0){
            List<Integer> temp=new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
            temp.add(nums[k]);
            ans.add(temp);
            j++;
            k--;
            while(j<k && nums[j]==nums[j-1]){
                j++;
            }
            while(j<k && nums[k]==nums[k+1]){
                k--;
            }
        }
        else if(sum<0){
            j++;
        }
        else {
            k--;
         }
        }
    }
    return ans;
    }
}