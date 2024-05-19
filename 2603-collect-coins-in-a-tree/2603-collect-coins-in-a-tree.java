class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
    int n = coins.length; 
    Set<Integer>[] tree = new HashSet[n]; 
    for (int i = 0; i < n; ++i) {
        tree[i] = new HashSet(); 
    }
    
    // Build the tree from the edges
    for (int[] e : edges) {
        tree[e[0]].add(e[1]); 
        tree[e[1]].add(e[0]); 
    }
    
    // Find the leaves with zero coins
    List<Integer> leaf = new ArrayList(); 
    for (int i = 0; i < n; ++i) {
        int u = i; 
        while (tree[u].size() == 1 && coins[u] == 0) {
            int v = tree[u].iterator().next(); 
            tree[u].remove(v); 
            tree[v].remove(u); 
            u = v; 
        }
        if (tree[u].size() == 1) {
            leaf.add(u); 
        }
    }
    
    // Remove the leaves one by one
    for (int sz = 2; sz > 0; --sz) {
        List<Integer> temp = new ArrayList(); 
        for (int u : leaf) {
            if (tree[u].size() == 1) {
                int v = tree[u].iterator().next(); 
                tree[u].remove(v); 
                tree[v].remove(u); 
                if (tree[v].size() == 1) {
                    temp.add(v); 
                }
            }
        }
        leaf = temp; 
    }
    
    // Count the remaining edges in the tree
    int ans = 0; 
    for (int i = 0; i < n; ++i) {
        ans += tree[i].size(); 
    }
    
    return ans; 
}
}