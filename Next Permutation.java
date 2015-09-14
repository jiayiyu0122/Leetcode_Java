/** Next Permutation **/
/*=====================================================================================
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
=====================================================================================*/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return;
        int nextLarge = -1;
        for(int i=nums.length-2; i>=0; i--){
            int j = i+1;
            while(j<nums.length){
                if(nums[j]>nums[i] && (nextLarge==-1 || nums[j]<nums[nextLarge])){
                    nextLarge = j;
                } 
                j++;
            }
            if(nextLarge!=-1){
                int temp = nums[nextLarge];
                nums[nextLarge] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }
        
        
        
        
        if(nextLarge==-1){
            Arrays.sort(nums);
        }
        return;
    }
}