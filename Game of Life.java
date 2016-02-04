/* Game of Life */
/*================================================================================================
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
================================================================================================*/

public class Solution {
    public void gameOfLife(int[][] board) {
        // dead->dead:0, live->dead:1, dead->live:10, live->live:11
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int live = getNumOfLife(board, i, j);
                if(board[i][j]==1){
                    if(live==2 || live==3){
                        board[i][j] = 11;
                    }
                }
                else{
                    if(live==3){
                        board[i][j] = 10;
                    }
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                board[i][j] /= 10;
            }
        }
        
        return;
    }
    
    public int getNumOfLife(int[][] board, int i, int j){
        int live = 0;
        for(int a=i-1; a<=i+1; a++){
            for(int b=j-1; b<=j+1; b++){
                if(a<0 || a>=board.length || b<0 || b>=board[0].length || (a==i && b==j)){
                    continue;
                }
                else{
                   if(board[a][b]%10==1){
                       live++;
                   } 
                }
            }
        }
        
        return live;
    }
}
