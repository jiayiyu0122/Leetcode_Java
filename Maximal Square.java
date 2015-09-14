/** Maximal Square **/
// 这道题是动态规划，核心的公式是 t[i][j] = min(t[i-1][j],t[i][j-1],t[i-1][j-1])+1.
// t[i][j] 里面放的是阶数。
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] t = new int[row][column];
        // first row value does not change;
        int max = 0;
        for(int j=0; j<column; j++){
            t[0][j] = Character.getNumericValue(matrix[0][j]);
            max = Math.max(t[0][j],max);
        }
        // first column value does not change;
        for(int i=0; i<row; i++){
            t[i][0] = Character.getNumericValue(matrix[i][0]);
        }
        for(int i=1; i<row; i++){
            for(int j=1; j<column; j++){
                if(matrix[i][j]=='1'){
                    int min = Math.min(t[i-1][j],t[i][j-1]);
                    min = Math.min(min,t[i-1][j-1]);
                    t[i][j] = min+1;
                    max = Math.max(t[i][j],max);
                }
                else{
                    t[i][j] = Character.getNumericValue(matrix[i][j]);
                }
                
            }
        }
        return max*max;
        
    }
}