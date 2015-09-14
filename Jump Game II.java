/** Jump Game II **/
/*================================================================================================
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
================================================================================================*/
public class Solution {
    public int jump(int[] nums) {
        // 动态规划
        // keep track of the last number of that can reach
        int reach = 0;
        int lastReach = 0;
        int step = 0;
        for(int i=0; i<nums.length; i++){
            if(i>lastReach){
                step++;
                lastReach = reach;
            }
            reach = Math.max(i+nums[i],reach);
        }
        if(reach<nums.length-1){
            return 0;
        }
        return step;
    }
}