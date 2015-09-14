/** First Missing Positive **/
/*============================================================================
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
============================================================================*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
    
        int i=0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(i=0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        
        if(min>1){
            return 1;
        }
        if(max<=0){
            return 1;
        }
        // [min,max]的数组
        int[] temp = new int[max-min+1];
        for(i=0; i<nums.length; i++){
            int distance = nums[i]-min;
            temp[distance] = 1;
        }
        
        int res = 0;
        boolean isFull = true;
        for(i=0; i<temp.length; i++){
            if(temp[i]==0){
                res = min+i;
                if(res>=1){
                    isFull=false;
                    break;   
                }
            }
        }
        if(isFull==false){
            return res;
        }
        if(min<=1){
            return max+1;
        }
        return min-1;
    }
}