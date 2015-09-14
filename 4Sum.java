/** 4Sum  **/
/*=============================================================================================
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 =============================================================================================*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int l = j+1;
                int k = nums.length-1;
                while(l<k){
                    if(nums[i]+nums[j]+nums[l]+nums[k]==target){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[k]);
                        set.add(temp);
                        l++;
                        k--;
                    }
                    
                    else if(nums[l]+nums[k]>target-nums[i]-nums[j]){
                        k--;
                    }
                    else{
                        l++;
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>(set);
        
        return res;
        
        
    }
}