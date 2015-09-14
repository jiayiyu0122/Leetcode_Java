/** Sudoku Solver **/
/*=================================================================
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
=================================================================*/
public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    
    public boolean helper(char[][] board, int i, int j){
        if(j>=9){
            return helper(board,i+1,0);
        }
        if(i==9){
            return true;
        }
        if(board[i][j]=='.'){
            for(int num=1; num<=9; num++){
                
                board[i][j] = (char)(num+'0');
                
                if(isValid(board,i,j)){
                    if(helper(board,i,j+1)){
                        return true;
                    }
                
                }
                board[i][j] = '.';
                
            }
        }
        else{
            return helper(board,i,j+1);
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int i, int j){
        for(int row=0; row<9; row++){
            if(row!=i && board[row][j]==board[i][j]){
                return false;
            }
        }
        
        for(int col=0; col<9; col++){
            if(col!=j && board[i][col]==board[i][j]){
                return false;
            }
        }
        
        for(int row=i/3*3; row<i/3*3+3; row++){
            for(int col=j/3*3; col<j/3*3+3; col++){
                if((row!=i || col!=j) && board[row][col]==board[i][j]){
                    return false;
                }
            }
            
        }
        
        return true;
    }
}