import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int n=s.length();
        int[] st=new int[n];
        int num = 0;
        int result = 0;
        int sign = 1; // Positive initially
        int top=-1;
        char[] a=s.toCharArray();
        for (int i = 0; i <n; i++) {
            char c = a[i];

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Parse the entire number
            } else if (c == '+' || c == '-') {
                result += sign * num; // Add the current num to result with proper sign
                num = 0; // Reset num for the next number
                sign = (c == '+') ? 1 : -1; // Update sign
            } else if (c == '(') {
                // Push the result and sign before entering the parentheses
                st[++top]=result;
                st[++top]=sign;
                result = 0;
                sign = 1; // Reset for the expression within parentheses
            } else if (c == ')') {
                result += sign * num; // Add the last num before the ')'
                num = 0; // Reset num for the next number
                result *= st[top--]; // Multiply with the sign before '('
                result += st[top--]; // Add the result before '('
            }
        }

        // Add the last num
        result += sign * num;

        return result;
    }
}