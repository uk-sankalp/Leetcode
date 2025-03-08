class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whitecount=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                whitecount++;
            }
        }
        int minrecolor=whitecount;
        for(int i=k;i<blocks.length();i++){
            if(blocks.charAt(i-k)=='W'){
                whitecount--;
            }
            if(blocks.charAt(i)=='W'){
                whitecount++;
            }
            minrecolor=Math.min(minrecolor,whitecount);
        }
        return minrecolor;
    }
}