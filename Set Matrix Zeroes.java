/** Set Matrix Zeroes **/
/*==============================================================================================
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
==============================================================================================*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 记录零的行号和列号
        List<Integer> rowZero = new ArrayList<Integer>();
        List<Integer> colZero = new ArrayList<Integer>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==0){
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
        // 把行号的行都变成零
        for(int i=0; i<rowZero.size(); i++){
            for(int j=0; j<col; j++){
                matrix[rowZero.get(i)][j]=0;
            }
        }
            
        // 把列号的列都变成零
        for(int i=0; i<colZero.size(); i++){
            for(int j=0; j<row; j++){
                matrix[j][colZero.get(i)]=0;
            }
        }
    }
}