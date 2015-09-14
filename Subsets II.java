/** Subsets II **/
/*================================================================================================
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
================================================================================================*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0 || nums==null) return res;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        helper(nums,0,temp,res);
        return res;
    }
    
    public void helper(int[] nums, int index, List<Integer> temp, List<List<Integer>> res){
            for(int i=index; i<nums.length; i++){
                temp.add(nums[i]);
                res.add(new ArrayList<Integer>(temp));
                helper(nums,i+1,temp,res);
                temp.remove(temp.size()-1);
                while(i<nums.length-1&&nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        
    }
