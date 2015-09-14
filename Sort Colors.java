/** Sort Colors **/

/*===============================================================================================================
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
===============================================================================================================*/
public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==0&&nums.length==1) return;
        int redPos = 0;
        int bluePos = nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0&&i>redPos){
                int temp = nums[i];
                nums[i] = nums[redPos];
                nums[redPos] = temp;
                redPos++;
                i--;
            }
            else if(nums[i]==2&&i<bluePos){
                int temp = nums[i];
                nums[i] = nums[bluePos];
                nums[bluePos] = temp;
                bluePos--;
                i--;
            }
        }
        
        return;
    }
}