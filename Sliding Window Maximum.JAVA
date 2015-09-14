/** Sliding Window Maximum **/
/*================================================================================================================================
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
================================================================================================================================*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return nums;
        }
        
        // nums.length>=k
        int[] max = new int[nums.length-k+1];
        for(int i=0; i<max.length; i++){
            max[i] = Integer.MIN_VALUE;
        }
        for(int i=0; i<nums.length-k+1; i++){
            if(i-1>=0 && nums[i-1]!=max[i-1]){
                if(nums[i+k-1]<max[i-1]){
                    max[i] = max[i-1];
                    continue;
                }
                else{
                    max[i] = nums[i+k-1];
                    continue;
                }
                
            }
            else if(i-1>=0 && nums[i-1]==max[i-1]){
                if(nums[i+k-1]>=max[i-1]){
                    max[i]=nums[i+k-1];
                    continue;
                }
            }
            // 
            for(int j=0; j<k; j++){
                if(nums[j+i]>max[i]){
                    max[i] = nums[j+i]; 
                }
            }
        }
        
        return max;
    }
}