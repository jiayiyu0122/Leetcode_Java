/** String to Integer (atoi) **/
/*===============================================================================================================================
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

===============================================================================================================================*/
// null or empty string
// +/-
// whitespace
// int_max/int_min
public class Solution {
    public int myAtoi(String str) {
        if(str.length()==0) return 0;
        str = str.trim();
        int flag = 1;
        int i=0;
        if(str.charAt(0)=='-'){
            flag = -1;
            i++;
        }
        else if(str.charAt(0)=='+'){
            i++;
        }
        
        long res = 0;
        while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            res = res*10+(str.charAt(i)-'0');
            i++;
            if(res*flag<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else if(res*flag>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        }
        
        
        
        return (int)res*flag;
    }
}