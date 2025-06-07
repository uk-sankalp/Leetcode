/*
Note:
In the Java version, to save time on building new S, I add the removing indices to a HashSet.
In C++, this can be done in-place and no need to make a HashSet.
*/
class Solution {
    public String clearStars(String s) {
        HashSet<Integer> removeSet = new HashSet<>(); 
        PriorityQueue<Character> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Integer> > indices =  
                  new ArrayList<ArrayList<Integer>>();
        for (int i = 0;i<26;i++){
            indices.add(new ArrayList<Integer>());
        }
        char ch;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '*'){
                removeSet.add(i);
                ch = pq.peek();
                removeSet.add(indices.get((int)(ch - 'a')).get(indices.get((int)(ch - 'a')).size()-1));
                indices.get((int)(ch - 'a')).remove(indices.get((int)(ch - 'a')).size()-1);
                if (indices.get((int)(ch - 'a')).size()==0){
                    pq.poll();
                }
                continue;
            }
            if (indices.get((int)(s.charAt(i) - 'a')).size() == 0){
                pq.add(s.charAt(i));
            }
            indices.get((int)(s.charAt(i) - 'a')).add(i);
        } 

        StringBuilder res = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (!removeSet.contains(i)){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}