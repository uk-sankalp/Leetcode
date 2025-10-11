class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count the frequency of each damage value
        Map<Integer, Long> damageFrequency = new HashMap<>();
        for (int damage : power) {
            damageFrequency.put(damage, damageFrequency.getOrDefault(damage, 0L) + 1);
        }

        // Step 2: Extract and sort the unique damage values
        List<Integer> uniqueDamages = new ArrayList<>(damageFrequency.keySet());
        Collections.sort(uniqueDamages);

        int totalUniqueDamages = uniqueDamages.size();
        long[] maxDamageDP = new long[totalUniqueDamages];

        // Step 3: Initialize the DP array with the first unique damage
        maxDamageDP[0] = uniqueDamages.get(0) * damageFrequency.get(uniqueDamages.get(0));

        // Step 4: Fill the DP array with the maximum damage calculations
        for (int i = 1; i < totalUniqueDamages; i++) {
            int currentDamageValue = uniqueDamages.get(i);
            long currentDamageTotal = currentDamageValue * damageFrequency.get(currentDamageValue);

            // Initially, consider not taking the current damage
            maxDamageDP[i] = maxDamageDP[i - 1];

            // Find the previous damage value that doesn't conflict with the current one
            int previousIndex = i - 1;
            while (previousIndex >= 0 && 
                   (uniqueDamages.get(previousIndex) == currentDamageValue - 1 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue - 2 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue + 1 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue + 2)) {
                previousIndex--;
            }

            // Update the DP value considering the current damage
            if (previousIndex >= 0) {
                maxDamageDP[i] = Math.max(maxDamageDP[i], maxDamageDP[previousIndex] + currentDamageTotal);
            } else {
                maxDamageDP[i] = Math.max(maxDamageDP[i], currentDamageTotal);
            }
        }

        // Return the maximum damage possible
        return maxDamageDP[totalUniqueDamages - 1];
    }
}