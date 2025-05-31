class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            s.add(wordList.get(i));
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        s.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;
            q.remove();
            if(word.equals(endWord)){
                return step;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replace=word.toCharArray();
                    replace[i]=ch;
                    String replacedword=new String(replace);
                    if(s.contains(replacedword)){
                        s.remove(replacedword);
                        q.add(new Pair(replacedword,step+1));
                    }
                }
            }

        }
         return  0;
    }
}