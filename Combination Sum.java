/** Combination Sum **/
/*===================================================================================================
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
===================================================================================================*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0) return res;
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        helper(candidates,0,target,temp,res);
        return res;
    }
    
    public void helper(int[] candidates, int index, int target, List<Integer> temp, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<Integer>(temp));
            
        }
        for(int i=index; i<candidates.length; i++){
            if(candidates[i]>target){
                return;
            }
            temp.add(candidates[i]);
            helper(candidates,i,target-candidates[i],temp,res);
            temp.remove(temp.size()-1);
            
        }
    } 
}