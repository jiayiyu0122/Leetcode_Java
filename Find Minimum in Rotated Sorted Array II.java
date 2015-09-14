/** Find Minimum in Rotated Sorted Array II **/
/*=======================================================
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
=======================================================*/
public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            
            while(l<r&&nums[l]==nums[l+1]){
                l++;
            }
            while(l<r&&nums[r]==nums[r-1]){
                r--;
            }
            
            int mid = (l+r)/2;
            if(nums[mid]>=nums[l]&&nums[mid]>nums[r]){
                l = mid+1;
            }
            else if(nums[mid]<=nums[l]&&nums[mid]<nums[r]){
                r = mid;
            }
            else{
                return nums[l];
            }
        }
        
        return nums[l];
    }
}