class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int ptr=0;ptr<words[i].length();ptr++){
                if(words[i].charAt(ptr)==x){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}