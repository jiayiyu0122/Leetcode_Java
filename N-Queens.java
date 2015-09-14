/** N-Queens **/
/*=================================================================================
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
=================================================================================*/


public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        helper(n,0,new int[n],res);
        return res;
    }
    
    public void helper(int n, int row, int[] col, List<List<String>> res){
        if(row==n){
            // row
            List<String> sList = new ArrayList<String>();
            for(int i=0; i<n; i++){
                StringBuilder temp = new StringBuilder();
                // column
                for(int j=0; j<n; j++){
                    if(col[i]==j){
                        temp.append('Q');
                    }
                    else{
                        temp.append('.');
                    }
                }
                
                sList.add(temp.toString());
            }
            res.add(sList);
            return;
        }
        else{
            // position in the board
            for(int i=0; i<n; i++){
                col[row] = i;
                if(check(row,col)){
                    helper(n,row+1,col,res);
                }
            }
        }
    }
    
    public boolean check(int row, int[] col){
        for(int i=0; i<row; i++){
            if(col[row]==col[i]||Math.abs(col[row]-col[i])==Math.abs(row-i)){
                return false;
            }
        }
        return true;
        
    }
}