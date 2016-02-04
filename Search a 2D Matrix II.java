/** Search a 2D Matrix II **/

/*=======================================================================
Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
=========================================================================*/
// 从右上往左下查找
// o(row+col)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;   
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        int curRow = 0;
        int curCol = col-1;
        
        while(curCol>=0 && curRow<row){
            if(target==matrix[curRow][curCol]){
                return true;
            }
            else if(target<matrix[curRow][curCol]){
                curCol--;
            }
            else if(target>matrix[curRow][curCol]){
                curRow++;
            }
        }
        
        return false;
    }
    
    
}