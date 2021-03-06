/** Jump Game **/
/*======================================================================================================
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
======================================================================================================*/
// keep track of the largest index that can be reached

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0) return true;
        if(nums.length==1 && nums[0]==0) return true;
        // keep track of the largest index that it can reach
        int max = 0;
        for(int i=0; i<nums.length; i++){
            // largest index it can reach
            if(i+nums[i]>max){
                max = i+nums[i];
            }
            // the farthest index can not reach i
            if(max<=i && nums[i]==0){
                return false;
            }
            if(max>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}