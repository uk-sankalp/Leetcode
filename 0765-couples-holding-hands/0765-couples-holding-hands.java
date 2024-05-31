class Solution {

public int minSwapsCouples(int[] row) {
    
    int n = row.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for(int i = 0; i < n; i++){
        map.put(row[i], i);
    }
    int swap = 0;
    for(int i = 0; i < n; i += 2){
        int first = row[i];
        int second = first ^ 1;
        
        int pos = map.get(second);
        
        if(pos == i+1){
            continue;
        }
        swap++;
        row[pos] = row[i+1];
        row[i+1] = second;
        
        map.put(second, i+1);
        map.put(row[pos], pos);
    }
    
    return swap;
}
}