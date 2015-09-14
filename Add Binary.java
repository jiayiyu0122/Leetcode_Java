/** Add Binary **/
/*===================================================================
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
===================================================================*/
public class Solution {
    public String addBinary(String a, String b) {
        if(a==null) return b;
        if(b==null) return a;
        int i = a.length()-1;
        int j = b.length()-1;
        int flag = 0;
        StringBuilder res = new StringBuilder();
        while(i>=0 || j>=0){
            int c1 = 0;
            int c2 = 0;
            if(i>=0){
                c1 = a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                c2 = b.charAt(j)-'0';
                j--;
            }
            int sum = c1+c2+flag;
            if(sum>=2){
                res.append(sum-2);
                flag = 1;
            }
            else{
                res.append(sum);
                flag = 0;
            }
        }
        
        if(flag==1){
            res.append(1);
        }
        
        return res.reverse().toString();
    }
}