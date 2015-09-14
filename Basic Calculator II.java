/** Basic Calculator II **/
/*==========================================================================================
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
==========================================================================================*/
public class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<String> stack = new Stack<String>();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            // 如果是空
            if(s.charAt(i)==' '){
                continue;
            }
            // 如果是数字
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                temp.append(s.charAt(i));
                if(i==s.length()-1){
                        stack.push(temp.toString());
                        temp = new StringBuilder();
                }
            }
            
            else{
                // 碰到的符号是乘或除
                 if(s.charAt(i)=='*' || s.charAt(i)=='/'){
                     String num1 = new String();
                     if(temp.toString().length()!=0){
                         num1 = temp.toString();
                     }
                     else{
                         num1 = stack.pop();
                     }
                     temp = new StringBuilder();
                     String operator = String.valueOf(s.charAt(i));
                     int j = i+1;
                     while(j<s.length() && s.charAt(j)>='0' && s.charAt(j)<='9'){
                         temp.append(s.charAt(j));
                         j++;
                     }
                    //  做乘除法
                    String num2 = temp.toString();
                    if(operator.equals("*")){
                        int r = Integer.parseInt(num1)*Integer.parseInt(num2);
                        stack.push(String.valueOf(r));
                    }
                    if(operator.equals("/")){
                        int r = Integer.parseInt(num1)/Integer.parseInt(num2);
                        stack.push(String.valueOf(r));
                    }
                    
                    temp = new StringBuilder();
                    i = j-1;
                 }
                 else{
                     if(temp.toString().length()!=0){
                         stack.push(temp.toString());
                     }
                     
                     stack.push(String.valueOf(s.charAt(i)));
                     temp = new StringBuilder();
                 }
            }
        }
        
        // 计算最后几位在stack的
        int res = 0;
        while(stack.empty()==false && stack.size()>1){
            String elem = stack.pop();
            String operater = stack.pop();
            if(operater.equals("+")){
                res += Integer.valueOf(elem);
            }
            else if(operater.equals("-")){
                res += 0 - Integer.valueOf(elem);
            }
        }
        
        String elem = stack.pop();
        res += Integer.valueOf(elem);
        
        return res;
    }
}