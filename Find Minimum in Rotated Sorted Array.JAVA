/** Find Minimum in Rotated Sorted Array **/
/*==========================================================================
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
==========================================================================*/
public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        // if(nums.length==1) return nums[0];
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>=nums[l]&&nums[mid]>nums[r]){
                l = mid+1;
            }
            else if(nums[mid]<=nums[l]&&nums[mid]<nums[r]){
                r = mid;
            }
            else if(nums[mid]>=nums[l]&&nums[mid]<nums[r]){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        
        return nums[l];
    }
}