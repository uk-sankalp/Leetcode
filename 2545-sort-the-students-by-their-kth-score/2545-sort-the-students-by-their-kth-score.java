class Solution {
    public int[][] sortTheStudents(final int[][] score, final int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);

        return score;
    }
}