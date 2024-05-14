class Solution {
    public int getMaximumGold(int[][] grid) {
		int max = 0;
		for(int r = 0; r<grid.length; r++)
			for(int c = 0; c<grid[r].length; c++)
				if(grid[r][c]!=0)
				  max = Math.max(max, maxGold(grid,r,c));
		return max;
    }

    public static int maxGold(int[][] grid, int row, int column){
      //Check Base cases
      if(row<0 || column<0 || row>=grid.length || column>=grid[row].length || grid[row][column]==0 )
			   return 0;
		
      //store current value and make current position as visited
		  int value = grid[row][column];
	   	grid[row][column]=0;
		  int result = 0;
		
      //iterate to up, left, down & right with calculating max value
		  result = Math.max(result, value+maxGold(grid, row, column-1));
	  	result = Math.max(result, value+maxGold(grid, row, column+1));
		  result = Math.max(result, value+maxGold(grid, row-1, column));
		  result = Math.max(result, value+maxGold(grid, row+1, column));

      //re-initialize the stored value to current position
	  	grid[row][column]= value;

      //return result
		  return result;
    }
}