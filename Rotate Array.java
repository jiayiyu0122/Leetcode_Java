/** Rotate Array **/
/*==========================================================================================
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
==========================================================================================*/
// o(1) is space,o(n) in complexity
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length){
            k = k%nums.length;
        }
        if(k==0) return;
        else{
            rotateArray(nums,0,nums.length-k-1);
            rotateArray(nums,nums.length-k,nums.length-1);
            rotateArray(nums,0,nums.length-1);
        }
        
    }
    
    public void rotateArray(int[] nums,int i,int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}