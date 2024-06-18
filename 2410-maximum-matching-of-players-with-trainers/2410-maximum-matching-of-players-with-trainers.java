class Solution {
    public int matchPlayersAndTrainers(int[] p, int[] t) {
        int n = p.length;
        int m = t.length;
        int i=0,j=0;
        Arrays.sort(p);
        Arrays.sort(t);
        int ans = 0;
        while(i<n && j<m){
            while(j<m && t[j] < p[i]) j++;
            if(j<m){
                ans++;
                i++;j++;
            }
        }
        return ans;
    }
}