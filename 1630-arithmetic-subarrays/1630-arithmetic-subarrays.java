class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();

        for (int q = 0; q < l.length; q++) {
            res.add(isArithmetic(Arrays.copyOfRange(nums, l[q], r[q] + 1)));
        }

        return res;        
    }

    private boolean isArithmetic(int[] sub) {
        Arrays.sort(sub);
        int diff = sub[1] - sub[0];
        for (int i = 2; i < sub.length; i++) {
            if (sub[i] - sub[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}