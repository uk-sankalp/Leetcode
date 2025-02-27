class Solution {
    int longest =2;
    Map<Integer,Integer> map = new HashMap<>(); 
    public int lenLongestFibSubseq(int[] arr) {
        int size = arr.length;
          for(int i=0;i<size;i++){
            map.put(arr[i],i);
          }
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){ 
            longest(i,j,arr,2);
            }
        }
        return longest>2?longest:0;
    }

    void longest(int i, int j, int[] arr,int count){
       if(count>2 && count>longest){
        longest= count;
       }
       if(j>=arr.length)
       {
        return;
       }
      if(map.containsKey(arr[i]+arr[j])){
         int k= map.get(arr[i]+arr[j]);
         longest(j,k,arr,count+1);
      }
     
 
   }


}