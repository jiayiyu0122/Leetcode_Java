/** Multiply Strings **/
/*===========================================================================
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
===========================================================================*/
public class Solution {
    public String multiply(String num1, String num2) {
        // reverse string
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        
        int[] d = new int[num1.length()+num2.length()];
        
        for(int i=0; i<num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                d[i+j] += (s1.charAt(i)-'0')*(s2.charAt(j)-'0');
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0; i<d.length; i++){
            int digit = d[i]%10;  // 当前位
            int carry = d[i]/10; //进位
            
            if(i+1<d.length){
                d[i+1] += carry;
            }
            
            res.insert(0,digit);
        }
        
        // remove 0
        while(res.charAt(0)=='0' && res.length()>1){
            res.deleteCharAt(0);
        }
        
        return res.toString();
    }
}