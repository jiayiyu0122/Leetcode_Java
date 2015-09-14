/** Spiral Matrix **/
/*=========================================================================================================
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
=========================================================================================================*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix.length==0) return res;
        if(matrix.length==1 && matrix[0].length==1){
            res.add(matrix[0][0]);
            return res;
        }
        int rStart = 0;
        int rEnd = matrix.length;
        int cStart = 0;
        int cEnd = matrix[0].length;
        while(rStart<rEnd && cStart<cEnd){
            for(int i=cStart; i<cEnd; i++){
                res.add(matrix[rStart][i]);
            }
            rStart++;
            if(rStart<rEnd){
                for(int i=rStart; i<rEnd; i++){
                    res.add(matrix[i][cEnd-1]);
                }
                cEnd--;
            }
            
            //last row
            if(rStart<rEnd){
                for(int i=cEnd-1; i>=cStart; i--){
                    res.add(matrix[rEnd-1][i]);
                }
                rEnd--;
            }
            // first column
            if(cStart<cEnd){
                for(int i=rEnd-1; i>=rStart; i--){
                    res.add(matrix[i][cStart]);
                }
                cStart++;
            }
        
        }
        return res;    
    }
    
}