class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb=new StringBuilder();
        sb.append('a');
        while(sb.length()<k){
            int n=sb.length();
            for(int i=0;i<n;i++){
               int c= (int)sb.charAt(i);
               if(c==127){
                sb.append('a');
               }
               else{
                sb.append((char)(c+1));
               }
            }
        }
        return sb.charAt(k-1);
    }
}