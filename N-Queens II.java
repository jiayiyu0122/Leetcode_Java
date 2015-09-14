/** N-Queens II **/
/*==================================================================================
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
==================================================================================*/
public class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        helper(n,0,new int[n]);
        return res;
    }
    
    public void helper(int n, int row, int[] col){
        if(row==n){
            res++;
        }
        else{
            // position
            for(int i=0; i<n; i++){
                col[row]=i;
                if(check(row,col)){
                    helper(n,row+1,col);
                }
            }
        }
    }
    
    public boolean check(int row, int[] col){
        for(int i=0; i<row; i++){
            // same column
            if(col[row]==col[i]){
                return false;
            }
            // on the dialogue
            else if(Math.abs(col[row]-col[i])==Math.abs(row-i)){
                return false;
            }
        }
        return true;
    }
}