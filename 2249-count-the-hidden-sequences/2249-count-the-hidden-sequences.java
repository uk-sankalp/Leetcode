class Solution {
        public int numberOfArrays(int[] diff, int lower, int upper) {
        long a = 0, ma = 0, mi = 0;
        for (int d: diff) {
            a += d;
            ma = Math.max(ma, a);
            mi = Math.min(mi, a);
        }
        return (int)Math.max(0, (upper - lower) - (ma - mi) + 1);
    }
}