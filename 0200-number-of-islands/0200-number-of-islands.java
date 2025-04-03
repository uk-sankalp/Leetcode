class Solution {
    static class Pair {
        int first, second;
        
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]== '1' && !visited[i][j]){
                    // visited[i][j]=true;
                    bfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(char[][] grid,boolean[][] visited,int r,int c){
        int[] ur={-1,0,1,0};
        int[] uc={0,1,0,-1};
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        visited[r][c]=true;
        while(!q.isEmpty()){
            Pair p=q.remove();
            int row=p.first;
            int col=p.second;
            for(int i=0;i<4;i++){
                int nr=row+ur[i];
                int nc=col+uc[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length 
                && !visited[nr][nc] && grid[nr][nc]== '1'){
                    q.add(new Pair(nr,nc));
                    visited[nr][nc]=true;
                }
            }

        }
    }
}