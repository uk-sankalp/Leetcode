class Solution {
    public int maxChunksToSorted(int[] arr) {
        int j=-1;
        int[] f=new int[10];
        int n=arr.length;
        for(int i=0;i<n;i++){
            f[arr[i]]=i;
        }
        int c=0;
        for(int i=0;i<n;i++){
            j=Math.max(j,f[i]);
            if(i==j)c++;
        }
        return c;
    }
}