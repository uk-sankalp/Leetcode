class Solution {
    public static int maxScore(String s) {
    int zeroscount=0;
    int onescount=0;
    int totalOnes=0;
    int bestscore=0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') totalOnes++;
        }
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)=='0'){
                zeroscount++;
            }
            else {
                onescount++;
            }
            int current=zeroscount-(onescount-totalOnes);
            bestscore=Math.max(bestscore,current);

        }
    return bestscore;

    }
}