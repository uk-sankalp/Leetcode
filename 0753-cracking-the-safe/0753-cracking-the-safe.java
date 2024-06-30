class Solution {
    public String crackSafe(int n, int k) {
        if(n==1){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < k; i++){
                sb.append(i);
            }
            return sb.toString();
        }
        int[] biggest_edge = new int[(int) Math.pow(k, n - 1)];
        Arrays.fill(biggest_edge, k - 1);
        StringBuilder sb = new StringBuilder("0".repeat(n - 1));
        int current = 0;
        while (biggest_edge[current] != -1) {
            int edge = biggest_edge[current]--;
            sb.append(edge);
            current = (current * k) % (int) Math.pow(k, n-1) + edge;
        }
        return sb.toString();
    }
    public static String mergeTwoStringShortest(String left, String right) {
        int noOverlap =longestHeadTailIntersection(left,right);
        return left.substring(0, left.length()) + right.substring(noOverlap, right.length());
    }
    private static int longestHeadTailIntersection( String T,  String P) {
        int n = T.length(), m = P.length();
        int[] pi = computePrefixFunction(P);
        int q = 0;
        for (int i = 0; i < n; i++) {
          while (q > 0 && P.charAt(q) != T.charAt(i)) {
            q = pi[q];
          }
          if (P.charAt(q) == T.charAt(i)) {
            q++;
          }
          if (q == m) {
            q = pi[q];
          }
        }
        return q;
      }
      private static int[] computePrefixFunction( String P) {
        int m = P.length();
        int[] pi = new int[m + 1];
        pi[1] = 0;
        for (int q = 1, k = 0; q < m; q++) {
          while (k > 0 && P.charAt(k) != P.charAt(q)) {
            k = pi[k];
          }
          if (P.charAt(k) == P.charAt(q)) {
            k++;
          }
          pi[q + 1] = k;
        }
        return pi;
      }
    public static boolean next(int[] arr, int k) {
        boolean remain = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i]++;
            if (arr[i] == k) {
                arr[i] = 0;
                remain = true;
            } else {
                remain = false;
                break;
            }
        }
        return !remain;
    }
    private static String numArrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (var i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}