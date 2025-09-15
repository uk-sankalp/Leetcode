class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count=0;
        String[] words=text.split(" ");
        if(brokenLetters.length()==0){
            return words.length;
        }
        if(brokenLetters.length()==26){
            return 0;
        }
        outer:
        for(int i=0;i<words.length;i++){
            for(int j=0;j<brokenLetters.length();j++){
                for(int k=0;k<words[i].length();k++){
                    if(words[i].charAt(k)==brokenLetters.charAt(j)){
                        continue outer;
                    }
                }
            }
            count++;
        }
        return count;
    }
}