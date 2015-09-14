/* Search for a Range */

/*=================================================================================================
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
=================================================================================================*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[left]==target){
                res[0] = left;
            }
            if(nums[right]==target){
                res[1] = right;
            }
            if(target<nums[mid]){
                right = mid-1;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else{
                if(res[0]==-1){
                    left++;
                }
                if(res[1]==-1){
                    right--;
                }
            }
            if(res[0]!=-1&&res[1]!=-1){
                return res;
            }
        }
        if(nums[left]==target){
            res[0] = right;
            res[1] = right;
        }
        
        return res;
    }
}