/** Surrounded Regions **/
// 方法一： depth first search, stack overflow
public class Solution {
    public void solve(char[][] board) {
        if(board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        // process the first and last row
        for(int i=0; i<col; i++){
            if(board[0][i]=='O'){
                fill(board,0,i);
            }
            if(board[row-1][i]=='O'){
                fill(board,row-1,i);
            }
        }
        // process the left and right column
        for(int i=0; i<row; i++){
            if(board[i][0]=='O'){
                fill(board,i,0);
            }
            if(board[i][col-1]=='O'){
                fill(board,i,col-1);
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        
        return;
    }
    public void fill(char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return;
        }
        if(board[i][j]=='O'){
            board[i][j]='*';
            fill(board,i-1,j);
            fill(board,i+1,j);
            fill(board,i,j-1);
            fill(board,i,j+1);
        }
        return;
    }
}