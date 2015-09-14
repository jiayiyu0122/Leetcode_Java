/** Remove Element **/
/*============================================================================================
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
============================================================================================*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int end = nums.length-1;
        int start = 0;
        while(start<=end){
            if(nums[start]!=val){
                start++;
            }
            else{
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end] = temp;
                end--;
            }
        }
        
        return start;
    }
}