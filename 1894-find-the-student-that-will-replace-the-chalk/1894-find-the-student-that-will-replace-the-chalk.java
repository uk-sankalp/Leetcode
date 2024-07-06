public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }

        k %= sum;
        int i;
        for (i = 0; i < n; i++) {
            if (k < chalk[i]) {
                break;
            } else {
                k -= chalk[i];
            }
        }

        return i;
    }
}