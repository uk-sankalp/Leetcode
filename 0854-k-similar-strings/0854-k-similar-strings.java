class Solution {
    public int kSimilarity(String a, String b) {
        int ans = 0;
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        ans += getAllPerfectMatches(achars, bchars);
        for (int i = 0; i < achars.length; i++) {
            if (achars[i] == bchars[i]) {
                continue;
            }
            return ans + checkAllOptions(achars, bchars, i, b);
        }
        return ans;
    }
    private int checkAllOptions(char[] achars, char[] bchars, int i, String b) {
        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j < achars.length; j++) {
            if (achars[j] == bchars[i] && achars[j] != bchars[j]) {
                swap(achars, i, j);
                ans = Math.min(ans, 1 + kSimilarity(new String(achars), b));
                swap(achars, i, j);
            }
        }
        return ans;
    }
    private int getAllPerfectMatches(char[] achars, char[] bchars) {
        int ans = 0;
        for (int i = 0; i < achars.length; i++) {
            if (achars[i] == bchars[i]) {
                continue;
            }
            for (int j = i + 1; j < achars.length; j++) {
                if (achars[j] == bchars[i] && bchars[j] == achars[i]) {
                    swap(achars, i, j);
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}