class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int[] ur={-1,0,1,0};
        int[] uc={0,1,0,-1};
        Queue<Pair> queue=new LinkedList<>();
        int t=0;
        int fresh=0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,t));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(!queue.isEmpty()){
            int r=queue.peek().row;
            int c=queue.peek().col;
            int tm=queue.peek().time;
            t=Math.max(t,tm);
            queue.remove();
            for(int i=0;i<4;i++){
                int nr=r+ur[i];
                int nc=c+uc[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && visited[nr][nc]!=2 && grid[nr][nc]==1){
                    visited[nr][nc]=2;
                    queue.add(new Pair(nr,nc,t+1));
                    count++;
                }
            }
        }
        if(count!=fresh){
            return -1;
        }
        return t;
    }
}
class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}