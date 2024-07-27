class Solution {
    public boolean canConvertString(String s, String t, int k) {
        // Edge case
        if (s.length() != t.length()) {
            return false;
        }

        // Other cases Scenario
        int[] character = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
            character[shift]++;
        }
        for (int i = 1; i < 26; i++) {
            if (i + (character[i] - 1) * 26 > k) {
                return false;
            }
        }
        return true;
    }
}