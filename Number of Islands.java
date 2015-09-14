/** Number of Islands  **/
/*=======================================================================================================
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
==========================================================================================================*/
//解题思路：把‘1’周围的数换成非‘1’。每次碰到一个‘1’的时候就在岛的数量上加一。
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int res = 0;
        // row
        int m = grid.length;
        // coloumn
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return res;
    }
    public void dfs(char[][]grid, int i, int j,int m, int n){
        if(i<0||i>=m||j<0||j>=n) return;
        if(grid[i][j]=='1'){
            grid[i][j]='2';
            dfs(grid,i-1,j,m,n);
            dfs(grid,i,j-1,m,n);
            dfs(grid,i+1,j,m,n);
            dfs(grid,i,j+1,m,n);
        }
        return;
    }
}