class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        boolean isUniversal = true;
        int[] subSetFreq = new int[26];
        for(String subset : words2) {
            int[] temp = new int[26];
            for(char ch : subset.toCharArray()) {
                temp[ch - 'a']++;
                subSetFreq[ch - 'a'] = Math.max(subSetFreq[ch - 'a'], temp[ch - 'a']);
            }
        }
        for(String word : words1) {
            
            int[] wordFreq = new int[26];
            for(char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }
            isUniversal = true;
            for(int i = 0; i < 26; i++) {
                if(subSetFreq[i] > wordFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) ans.add(word);
        }
        return ans;
    }

    boolean isSubSet(String first, String second) {
        int i = 0, j = 0;
        while(i < first.length() && j < second.length()) {
            if(first.charAt(i) == second.charAt(j)) {
                i++; j++;
            } else {
                i++;
            }
        }
        return j == second.length();
    }
}