class Solution {
    public int totalFruit(int[] tree) {
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<fruits.length;i++){
        //     Set<Integer> set=new HashSet<>();
        //     int count=0;
        //     for(int j=i;j<fruits.length;j++){
        //         set.add(fruits[j]);
        //         if(set.size()>2){
        //             break;
        //         }
        //         count++;
        //     }
        //     max=Math.max(max,count);
        // }
        // return max;
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }
}