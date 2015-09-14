/** 3Sum Closest **/
/*============================================================================================================================
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
============================================================================================================================*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==target){
                    close = 0;
                    return target;
                }
                else if(nums[j]+nums[k]>target-nums[i]){
                    
                    if(Math.abs(target-nums[i]-nums[k]-nums[j])<close){
                        close = Math.abs(target-nums[i]-nums[k]-nums[j]);
                        sum = nums[i]+nums[k]+nums[j];
                    }
                    
                    
                    k--;
                    while(j<k&&nums[k+1]==nums[k]){
                        k--;
                    }
                }
                else{
                    if(Math.abs(target-nums[i]-nums[k]-nums[j])<close){
                        close = Math.abs(target-nums[i]-nums[k]-nums[j]);
                        sum = nums[i]+nums[k]+nums[j];
                    }
                    
                    j++;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }
        
        return sum;
    }
}