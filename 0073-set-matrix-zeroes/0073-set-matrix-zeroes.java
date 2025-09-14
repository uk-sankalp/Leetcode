class Solution {
    public void setZeroes(int[][] matrix) {
    // -------------Brute Force------------------

    //     int n=matrix.length;
    //     int m=matrix[0].length;
    //    boolean[][] visited=new boolean[n][m];
    //    for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //         if(matrix[i][j]==0){
    //             markvisited(visited,i,j);
    //         }
    //     }
    //    }
    //    for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //         if(visited[i][j]==true){
    //             matrix[i][j]=0;
    //         }
    //     }
    //    }
    // }
    // public static void markvisited(boolean[][] visited,int i,int j){
    //     for(int s=0;s<visited[0].length;s++){
    //         if(!visited[i][s]){
    //             visited[i][s]=true;
    //         }
    //     }
    //     for(int s=0;s<visited.length;s++){
    //         if(!visited[s][j]){
    //             visited[s][j]=true;
    //         }
    //     }

    // ------------------------Better Approach---------
    // int n=matrix.length;
    // int m=matrix[0].length;
    // int[] row=new int[n];
    // int[] col=new int[m];
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //         if(matrix[i][j]==0){
    //             row[i]=col[j]=1;
    //         }
    //     }
    // }
    //   for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //        if(row[i]==1 || col[j]==1){
    //         matrix[i][j]=0;
    //        }
    //     }
    // }

    // ------------------------------Optimal Approach----------------------------------
    int col0=1;
    int n=matrix.length;
    int m=matrix[0].length;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(matrix[i][j]==0){
                matrix[i][0]=0;
                if(j!=0){
                    matrix[0][j]=0;
                }
                else{
                    col0=0;
                }
            }
        }
    }
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
              if(matrix[i][0]==0 || matrix[0][j]==0){
                matrix[i][j]=0;
              }
        }
    }
    if(matrix[0][0]==0){
        for(int i=0;i<m;i++){
            matrix[0][i]=0;
        }
    }
    if(col0==0){
        for(int i=0;i<n;i++){
            matrix[i][0]=0;
        }
    }
    }
}