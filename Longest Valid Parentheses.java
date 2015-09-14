/** Longest Valid Parentheses **/
/*===============================================================================================================
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
===============================================================================================================*/

// 记录括号的位置
public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int maxLength = 0;
        int last = -1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    last = i;
                }
                else{
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLength = Math.max(i-last,maxLength);
                    }
                    else{
                        maxLength = Math.max(i-stack.peek(),maxLength);
                    }
                    
                }
            }
        }
        
        
        
        return maxLength;
    }
}