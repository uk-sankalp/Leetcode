class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] sone=s1.toCharArray();
        char[] stwo=s2.toCharArray();
        int count=0;
        for(int i=0;i<sone.length;i++){
            if(sone[i]!=stwo[i]){
                count++;
            }
        }
        if(count>2){
            return false;
        }
        Arrays.sort(sone);
        Arrays.sort(stwo);
        if(!Arrays.equals(sone, stwo)){
            return false;
        }


        return true;
    }
}