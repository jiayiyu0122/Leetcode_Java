/** Combination Sum III **/
/*===============================================================
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

===============================================================*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(temp,res,1,k,n);
        return res;
    }
    
    public void helper(List<Integer> temp, List<List<Integer>> res, int start, int k, int n){
        if(n==0 && temp.size()==k){
            List<Integer> list = new ArrayList<Integer>(temp);
            res.add(list);
            return;
        }
        
            for(int i=start; i<=9; i++){
                if(i>n){
                    break;
                }
                if(temp.size()>k) break;
                temp.add(i);
                helper(temp,res,i+1,k,n-i);
                temp.remove(temp.size()-1);
            
            }
            
        }
    }
