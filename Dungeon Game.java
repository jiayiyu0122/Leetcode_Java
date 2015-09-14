/** Dungeon Game **/
/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


*/
// 动态规划
// 维护一个动态二维矩阵，dp[i][j]表示的是从i，j,这个位置走到右下角的位置的最小的初始的血量。

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] health = new int[row][col];
        
        health[row-1][col-1] = Math.max(1-dungeon[row-1][col-1],1);
        
        for(int i=row-2; i>=0; i--){
            health[i][col-1] = Math.max(health[i+1][col-1]-dungeon[i][col-1],1);
        }
        
        for(int j=col-2; j>=0; j--){
            health[row-1][j] = Math.max(health[row-1][j+1]-dungeon[row-1][j],1);
        }
        
        for(int i=row-2; i>=0; i--){
            for(int j=col-2; j>=0; j--){
                int down = Math.max(health[i+1][j]-dungeon[i][j],1);
                int right = Math.max(health[i][j+1]-dungeon[i][j],1);
                health[i][j] = Math.min(down,right);
            }
        }
        
        return health[0][0];
    }
}