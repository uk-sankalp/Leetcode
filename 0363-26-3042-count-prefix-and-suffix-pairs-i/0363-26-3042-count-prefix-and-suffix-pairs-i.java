class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private boolean isPrefixAndSuffix(String a, String b) {
        int lenA = a.length();
        if (lenA > b.length()) return false;
        return a.equals(b.substring(0, lenA)) && a.equals(b.substring(b.length() - lenA));
    }
}