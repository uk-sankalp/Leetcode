class Solution {
    public int[] divisibilityArray(String word, int m) {
    int n = word.length();
    int[] div = new int[n];
    long remainder = 0;
    for (int i = 0; i < n; i++) {
            int digit = word.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % m;
            if (remainder == 0) {
                div[i] = 1;
            }
        }
        return div;
    }
}