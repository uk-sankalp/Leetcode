class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] ur={-1,0,1,0};
        int[] uc={0,1,0,-1};
        int[][] visited=new int[matrix.length][matrix[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.remove();
            for(int i=0;i<matrix.length;i++){
                matrix[i][c]=0;
            }
            for(int i=0;i<matrix[0].length;i++){
                matrix[r][i]=0;
            }
            // for(int i=0;i<4;i++){
            //     int nr=r+ur[i];
            //     int nc=c+uc[i];
            //     if(nr>=0 && nc>=0 && nr<matrix.length && nc<matrix[0].length){
            //         matrix[nr][nc]=0;
            //     }
            // }
        }
    }
}