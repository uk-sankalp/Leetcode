class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        findcombo(candidates,0,target,ans,ds);
        return ans;
    }
    public static void findcombo(int[] candidates,int ind,int target,List<List<Integer>> ans,List<Integer> ds){
        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList(ds));
            }
            return;
        }
        if(candidates[ind]<=target){
        ds.add(candidates[ind]);
        findcombo(candidates,ind,target-candidates[ind],ans,ds);
        ds.remove(ds.size()-1);
        }
        findcombo(candidates,ind+1,target,ans,ds);
    }
}