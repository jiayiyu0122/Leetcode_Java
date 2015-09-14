/** Trapping Rain Water  **/

/*============================================================================================
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

============================================================================================*/
public class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        // trapping raing the 公式是：min(左边最高的bar，右边最高的bar)-i的bar的高度
        // 先找出在i的位置左边的最高的bar的高度
        int[] left = new int[height.length];
        left[0] = height[0];
        for(int i=1; i<height.length; i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        
        int sum = 0;
        for(int i=0; i<height.length; i++){
            int temp = Math.min(left[i],right[i])-height[i];
            if(temp>0){
                sum += temp;
            }
        }
        
        return sum;
        
        
    }
}