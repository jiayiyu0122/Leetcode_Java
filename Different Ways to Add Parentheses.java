/** Different Ways to Add Parentheses **/
/*==================================================================
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
==================================================================*/
// divide and conquer

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input==null || input.length()==0) return res;
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c!='+' && c!='-' && c!='*') continue;
            
            List<Integer> left = diffWaysToCompute(input.substring(0,i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
            
            for(Integer m:left){
                for(Integer n:right){
                    if(c=='+'){
                        res.add(m+n);
                    }
                    else if(c=='-'){
                        res.add(m-n);
                    }
                    else{
                        res.add(m*n);
                    }
                }
            }
            
        }
        
        if(res.size()==0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}