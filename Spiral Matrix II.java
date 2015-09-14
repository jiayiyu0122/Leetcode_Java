/** Spiral Matrix II **/
/*====================================================================================================
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
====================================================================================================*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int count = 1;
        while(count<=Math.pow(n,2)){
            // row toward right
            for(int i=colStart; i<=colEnd; i++){
                matrix[rowStart][i] = count;
                count++;
                
            }
            rowStart++;
            // col downward
            for(int i=rowStart; i<=rowEnd; i++){
                matrix[i][colEnd] = count;
                count++;
                
            }
            colEnd--;
            // row toward left
            for(int i=colEnd; i>=colStart; i--){
                matrix[rowEnd][i] = count;
                count++;
                
            }
            rowEnd--;
            // col upward
            for(int i=rowEnd; i>=rowStart; i--){
                matrix[i][colStart] = count;
                count++;
                
            }
            colStart++;
        }
        return matrix;
    }
}