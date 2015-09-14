/** Evaluate Reverse Polish Notation **/
/*=====================================================================================
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
======================================================================================*/
// 这道题用stack的方法来做就很容易得到
// 注意：java 里面比较两个string的值相等，应该用，s1.equals(s2) 
// 而不是 s1==s2(这样比较的是两个string的reference).
import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        ArrayList<Integer> stack = new ArrayList<Integer>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("/")||tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")){
                int i1 = stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                int i2 = stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                int res = 0;
                if(tokens[i].equals("+")) res = i2+i1;
                else if(tokens[i].equals("-")) res = i2-i1;
                else if(tokens[i].equals("*")) res = i2*i1;
                else if(tokens[i].equals("/")) res = i2/i1;
                stack.add(res);
            }
            else{
                stack.add(Integer.parseInt(tokens[i]));
            }
            
        }
        return stack.get(0);
    }
}