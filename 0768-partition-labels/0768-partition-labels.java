class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        List<Integer> ans=new ArrayList<>();
        int prev=-1;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,map.get(s.charAt(i)));
            if(end==i){
                ans.add(end-prev);
                prev=end;
            }
        }
        return ans;
    }
}