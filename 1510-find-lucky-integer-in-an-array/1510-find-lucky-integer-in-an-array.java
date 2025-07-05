class Solution {
    public int findLucky(int[] arr) {
        // int lucky=-1;
        // for(int i=0;i<arr.length;i++){
        //     int count=0;
        //     for(int j=0;j<arr.length;j++){
        //         if(arr[j]==arr[i]){
        //             count++;
        //         }
        //     }
        //     if(count==arr[i]){
        //         lucky=Math.max(lucky,count);
        //     }
        // }
        // return lucky;
        int lucky=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getKey()==entry.getValue()){
                lucky=Math.max(lucky,entry.getKey());
            }
        }
        return lucky;
    }
}