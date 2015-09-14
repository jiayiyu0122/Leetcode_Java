/** Valid Sudoku  **/
/*================================================================================================================
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
================================================================================================================*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9) return false;
        int row = board.length;
        int col = board[0].length;
        // each row
        for(int i=0; i<row; i++){
            Set<Character> hs = new HashSet<Character>();
            for(int j=0; j<col; j++){
                char c = board[i][j];
                if(c!='.'){
                    if(hs.contains(c)){
                        return false;
                    }
                    else{
                        hs.add(c);
                    }
                }
            }
        }
        
        // each column
        for(int i=0; i<col; i++){
            Set<Character> hs = new HashSet<Character>();
            for(int j=0; j<row; j++){
                char c = board[j][i];
                if(c!='.'){
                    if(hs.contains(c)){
                        return false;
                    }
                    else{
                        hs.add(c);
                    }
                }
            }
        }
        
        // each block
        for(int block=0; block<9; block++){
            Set<Character> hs = new HashSet<Character>();
            for(int i=block/3*3; i<block/3*3+3; i++){
                for(int j=block%3*3; j<block%3*3+3; j++){
                    char c = board[i][j];
                    if(c!='.'){
                        if(hs.contains(c)){
                            return false;
                        }
                        else{
                            hs.add(c);
                        }
                    }
                }
            }
        }
        
        return true;
        
        
    }
}