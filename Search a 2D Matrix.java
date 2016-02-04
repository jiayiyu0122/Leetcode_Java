// 复杂度 o(log(row)+log(col))
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(matrix[mid][0]==target) {
                return true;
            }
            else if(matrix[mid][0]>target) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        
        int row = end;
        if(row<0) return false;
        start = 0;
        end = matrix[0].length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(matrix[row][mid]==target) {
                return true;
            }
            else if(matrix[row][mid]<target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        
        return false;
    }

// 把2d的matrix转换成1d的array来看
// 注意的是下标之间的转换
// 复杂度 o(log(row+col))
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = row*col - 1;
        
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(matrix[mid/col][mid%col]==target) {
                return true;
            }
            else if(matrix[mid/col][mid%col]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        
        return false;
    }
}