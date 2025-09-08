class Solution {
    public static boolean hasZero(int num) {
    String s = String.valueOf(num);
    return s.contains("0");
}
    public int[] getNoZeroIntegers(int n) {
        int half=n/2;
        if(n%2==0){
            int h1=half;
            int h2=half;
            while(hasZero(h1) || hasZero(h2)){
                h1=h1+1;
                h2=h2-1;
            }
            return new int[]{h1,h2};
        }
        else{
            int h1=half+1;
            int h2=half;
            while(hasZero(h1) || hasZero(h2)){
                h1=h1+1;
                h2=h2-1;
            }
            return new int[]{h1,h2};
        }
    }
}