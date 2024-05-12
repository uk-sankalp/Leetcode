class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int next: nums1) {
            set1.add(next);
        }
        for (int next: nums2) {
            if (set1.contains(next)) {
                set2.add(next);
            }
        }
        int[] res = new int[set2.size()];
        int i =0;
        for (int next: set2) {
            res[i] = next;
            i++;
        }
        return res;
    }
}