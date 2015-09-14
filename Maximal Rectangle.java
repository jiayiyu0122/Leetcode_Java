/** Maximal Rectangle **/

/*===========================================================
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.
===========================================================*/
// 这道题和Largest Rectangle in Histogram类似
// 注意设置高度的数列要多设置一位，这样保证最后一个一定是零的话，就可以算完整了
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height = new int[row][col+1];
        
        // set the height of the first row
        for(int i=0; i<col; i++){
            if(matrix[0][i]=='1'){
                height[0][i] = 1;
            }
        }
        
        // set the height of the rest
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]=='1'){
                    height[i][j] = height[i-1][j]+1;
                }
            }
        }
        
        // calculate the max rec of each row
        int[] maxArea = new int[row];
        for(int i=0; i<row; i++){
            Stack<Integer> stack = new Stack<Integer>();
            int j=0;
            while(j<col+1){
                if(stack.empty()||height[i][j]>=height[i][stack.peek()]){
                    stack.push(j);
                    j++;
                }
                else{
                    int t = stack.pop();
                    maxArea[i] = Math.max(maxArea[i], height[i][t]*(stack.empty()? j:j-stack.peek()-1));
                }
               
            }
            
        }
        
        int res = maxArea[0];
        for(int i=1; i<row; i++){
            if(maxArea[i]>res){
                res = maxArea[i];
            }
        }
        
        return res;
    }
}