import java.math.BigInteger;
import java.util.ArrayList;

class Solution {
    public String removeDigit(String numbers, char digit) {
        ArrayList<String> a1 = new ArrayList<>();
        StringBuilder sb = new StringBuilder(numbers);

        for (int i = 0; i < sb.length(); i++) {
            if (digit == sb.charAt(i)) {
                sb.deleteCharAt(i);
                a1.add(sb.toString()); 
                sb = new StringBuilder(numbers); 
            }
        }

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < a1.size(); i++) {
            BigInteger num = new BigInteger(a1.get(i));
            if (num.compareTo(result) > 0) {
                result = num;
            }
        }
        return result.toString();
    }
}