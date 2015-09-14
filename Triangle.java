/** Triangle **/
/*==========================================================================================================================
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
==============================================================================================================================*/
//这道题用自下而上的思路。 上面一层每一个元素的最小值路径都是下面相邻的元素的最小路径与其元素的和。
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] sum = new int[row];
        for(int i=0; i<row;i++){
            sum[i] = triangle.get(row-1).get(i);
        }
        for(int i=row-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                sum[j] = Math.min(sum[j],sum[j+1])+triangle.get(i).get(j); 
            }
        }
        return sum[0];
        
    }
}