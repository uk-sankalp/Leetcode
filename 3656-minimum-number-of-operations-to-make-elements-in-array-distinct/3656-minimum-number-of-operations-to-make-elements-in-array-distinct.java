import java.util.HashMap;

class Solution {
    public int minimumOperations(int[] array) {
        // Count the frequency of each element in the array
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int value : array) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        // Count duplicates
        int totalDuplicates = 0;
        for (int count : countMap.values()) {
            if (count > 1) {
                totalDuplicates += count - 1;
            }
        }

        int operationCount = 0;
        while (totalDuplicates > 0) {
            if (array.length >= 3) {
                // Create a new array excluding the first three elements
                int[] newArray = new int[array.length - 3];
                System.arraycopy(array, 3, newArray, 0, newArray.length);
                array = newArray;
            } else {
                array = new int[0];  // Clear the array
            }

            // Recalculate frequencies after removal
            countMap.clear();
            for (int value : array) {
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }

            // Recalculate duplicates
            totalDuplicates = 0;
            for (int count : countMap.values()) {
                if (count > 1) {
                    totalDuplicates += count - 1;
                }
            }

            operationCount++;
        }

        return operationCount;
    }
}