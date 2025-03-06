class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int maxfreq=Integer.MIN_VALUE;
        int maxkey=-1;
        for (Integer key : map.keySet()) {
         if(map.get(key)>maxfreq){
            maxfreq=map.get(key);
            maxkey=key;
         }
        }
        ans[0]=maxkey;
        for(int i=1;i<=grid.length * grid[0].length;i++){
            if(!map.containsKey(i)){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}