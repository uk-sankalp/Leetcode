import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];

                // Pehle frequency badhao
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Ab sare products ke liye valid tuples count karo
        for (int freq : productCount.values()) {
            if (freq > 1) {  // Sirf tab calculate karna jab freq >= 2 ho
                result += 8 * (freq * (freq - 1)) / 2;
            }
        }

        return result;
    }
}
