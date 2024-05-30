class Solution {
    public int uniquePathsIII(final int[][] grid) {
        final int m = grid.length, n = grid[0].length;

        int startX = 0, startY = 0, walkableSquares = 0;

        for(int x = 0; x < m; ++x) {
            for(int y = 0; y < n; ++y) {
                if(grid[x][y] == 0) {
                    walkableSquares++;
                } else if(grid[x][y] == 1) {
                    startX = x;
                    startY = y;
                }
            }
        }

        return this.dfs(grid, startX, startY, walkableSquares);
    }

    private int dfs(final int[][] grid, final int x, final int y, int walkableSquares) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1)
            return 0;

        if(grid[x][y] == 2)
            return walkableSquares == -1 ? 1 : 0;

        walkableSquares--;

        final int tmp = grid[x][y];
        grid[x][y] = -1;

        final int total = dfs(grid, x + 1, y, walkableSquares) + dfs(grid, x, y + 1, walkableSquares) +
                dfs(grid, x - 1, y, walkableSquares) + dfs(grid, x, y - 1, walkableSquares);

        grid[x][y] = tmp;

        return total;
    }
}