/** Valid Parentheses **/
/*=====================================================================================================================
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
=====================================================================================================================*/
public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']'){
                    return false;
                }
                stack.push(s.charAt(i));
            }
            else{
                if(s.charAt(i)==')'){
                    if(stack.pop()!='(') return false;
                }
                else if(s.charAt(i)==']'){
                    if(stack.pop()!='[') return false;
                }
                else if(s.charAt(i)=='}'){
                    if(stack.pop()!='{') return false;
                }
                else{
                    stack.push(s.charAt(i));
                }
                
            }
            
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}