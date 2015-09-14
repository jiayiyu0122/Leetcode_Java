/** Generate Parentheses **/
/*====================================================================================================
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
===================================================================================================*/
// 用recursive的方法

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        String s = new String();
        if(n==0) return res;
        addParenthesis(n,0,0,s,res);
        return res;
    }
    public void addParenthesis(int n, int left, int right, String s, ArrayList<String> res){
        if(left<right){
            return;
        }
        if(left==right && left==n){
            res.add(s);
            return;
        }
        if(left==n &&left>right){
            addParenthesis(n,left,right+1,s+")",res);
            return;
        }
        addParenthesis(n,left+1,right,s+"(",res);
        addParenthesis(n,left,right+1,s+")",res);
    }
}