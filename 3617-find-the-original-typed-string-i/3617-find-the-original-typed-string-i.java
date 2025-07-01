class Solution {
    public int possibleStringCount(String word) {
        int count=1;
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(int i=0;i<word.length();i++){
        //     map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        // }
        // for(Map.Entry<Character,Integer> entry:map.entrySet()){
        //     int value=entry.getValue();
        //     if(value>1){
        //         count+=value-1;
        //     }
        // }
        for(int i=0;i<word.length()-1;i++){
            if(word.charAt(i)==word.charAt(i+1)){
                count++;
                }
            }
        return count;
    }
}