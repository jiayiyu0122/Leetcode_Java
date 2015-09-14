/** Valid Number **/
/*====================================================================
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
====================================================================*/

public class Solution {
// 主要考虑的是数字,'.','e'和'E','+','-'
// '.'前面不能是有e或者E, 前面一位是数字（不能是第一位）或者 后面一位是数字（不能是最后一位）
// 'e'或者'E'前面不能有e或者E出现，不能是第一位或者最后一位
// 正负号：必须是第一位，或者在e或者E后面一位
public boolean isNumber(String s) {
    if(s==null)
        return false;
    s = s.trim();
    if(s.length()==0)
        return false;
    boolean dotFlag = false;
    boolean eFlag = false;
    for(int i=0;i<s.length();i++)
    {
        switch(s.charAt(i))
        {
            case '.':
                if(dotFlag || eFlag 
                || ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')) 
                    && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))))
                    return false;
                dotFlag = true;
                break;
            case '+':
            case '-':
                if((i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))
                  || (i==s.length()-1 || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.')))
                    return false;
                break;
            case 'e':
            case 'E':
                if(eFlag || i==s.length()-1 || i==0)
                    return false;
                eFlag = true;
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                break;
            default:
                return false;
        }
    }
    return true;
}
}