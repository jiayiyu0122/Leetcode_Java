/** Longest Consecutive Sequence **/
/*================================================================================================
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
================================================================================================*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> numSet = new HashSet<Integer>();
        for(int e:nums){
            numSet.add(e);
        }

        int largest = 0;
        for(int e:nums){
            int left = e-1;
            int right = e+1;
            int count = 1;
            while(numSet.contains(left)){
                count++;
                numSet.remove(left);
                left--;
            }
            while(numSet.contains(right)){
                count++;
                numSet.remove(right);
                right++;
            }
            largest = Math.max(largest,count);
        }
        
        return largest;
    }
}