class Solution {
    public List<Boolean> ans;
    public int[] segTree;
    public List<Boolean> getResults(int[][] q) {
        ans = new ArrayList<>();
        int m = q.length;
        int n = 50001;
        segTree = new int[2*n];
        segTree[n] = 1000000;
        for(int i = n-1; i > 0; i--) {
            segTree[i] = Math.max(segTree[i*2], segTree[i*2+1]);
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(1000000);
        
        for(int i = 0; i < m; i++) {
            if(q[i][0]==1) {
                int x = q[i][1];
                int prev = set.floor(x);
                int next = set.ceiling(x);
                set.add(x);
                modify(prev, x-prev, n);
                modify(x, next-x, n);
            } else { //q[i][0] == 2
                int x = q[i][1];
                int sz = q[i][2];
                if(sz > x) {
                    ans.add(false);
                    continue;
                }
                int max = query(0, x-sz, n);
                ans.add(max >= sz);
            }
        }
        
        return ans;
    }
    
    public void modify(int idx, int val, int n) {
        idx += n;
        segTree[idx] = val;
        idx/=2;
        while(idx > 0) {
            segTree[idx] = Math.max(segTree[idx*2], segTree[idx*2+1]);
            idx/=2;
        }
    }

    public int query(int l, int r, int n) { //interval [l, r]
        int res = 0;
        l+=n; r+=n;
        while(l<=r) {
            if(l%2==1) res = Math.max(res, segTree[l++]);
            if(r%2==0) res = Math.max(res, segTree[r--]);
            l/=2; r/=2;
        }
        return res;
    }
}