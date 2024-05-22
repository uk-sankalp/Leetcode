class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        List<String> res=new ArrayList<>();
        
        Map<Character,int[]> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i))[1]=i;
            }else{
                map.put(s.charAt(i),new int[]{i,i});
            }
        }
        
        int prevEnd=-1;
        for(int i=0;i<s.length();i++){
            
            int start=map.get(s.charAt(i))[0];
            //if i is the left most index of this character only then we can start a substring here
            if(start==i){
                int newEnd= getRightMost(s,map,i);
                if(newEnd!= -1){
                    //if a new substring is found
                    if(newEnd>prevEnd){
                        res.add("");
                    }
                    prevEnd=newEnd;
                    // if new end is less than the prev End which means inside prev substring we found a more shorter substring
                    res.set(res.size()-1,s.substring(i,prevEnd+1));     
                }
            }
            
            
        }
        
        return res;
      
    }
    
    public int getRightMost(String s,Map<Character,int[]> map,int start){
        int end=map.get(s.charAt(start))[1];
        
        for(int i=start;i<=end;i++){
            //if any inside substring has a start before this substring, then we will return -1,
            //which means we cannot start a substring at index i as it contains a char whose start
            //is less than this i .
            if(map.get(s.charAt(i))[0]<start) return -1;
            end=Math.max(end,map.get(s.charAt(i))[1]);              
        }
        
        return end;
    }
    
    
}