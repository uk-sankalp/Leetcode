class Solution {
        public int minimumObstacles(int[][] grid) {
    
    int row = grid.length;
    int col = grid[0].length;
    
    int[][] obs = new int[row][col];
    for (int[] ob : obs) {
        Arrays.fill(ob, Integer.MAX_VALUE);
    }
    
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    
    q.offer(new int[] {0, 0, grid[0][0]});
    int[] dir = new int[] {0, 1, 0, -1, 0};
    
    while(!q.isEmpty()) {
        int[] curr = q.poll();
        int ob = curr[2];
        if (curr[0] == row - 1 && curr[1] == col - 1) {
            return ob;
        }
        for (int i = 0; i < 4; i++) {
            int x = curr[0] + dir[i];
            int y = curr[1] + dir[i + 1];
            
            if (x < 0 || y < 0 || x >= row || y >= col) {
                continue;
            }
            int nob = ob + grid[x][y];
            
            if (nob < obs[x][y]) {
                obs[x][y] = nob;
                q.offer(new int[] {x, y, nob});
            }
            
        }
    }
    
    return obs[row - 1][col - 1];
    
}
        
    }