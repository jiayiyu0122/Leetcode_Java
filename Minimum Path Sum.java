/** Minimum Path Sum **/
/*======================================================
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.
======================================================*/


public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i-1>=0 && j-1>=0){
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
                else if(i-1<0 && j-1<0){
                    continue;
                }
                else if(i-1<0){
                    grid[i][j] += grid[i][j-1];
                }
                else if(j-1<0){
                    grid[i][j] += grid[i-1][j];
                }
                
            }
        }
        
        return grid[row-1][col-1];
    }
}