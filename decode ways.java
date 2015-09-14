/** Decode Ways **/
/*===============================================================================================
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
===============================================================================================*/

// 这道题的基本思路是num[i] = num[i-1]+num[i-2]
// 当当前这位的letter是valid的，num[i] = num[i]+num[i-1];
// 当当前这位的letter与前一位letter加一起是valid的，num[i] = num[i]+num[i-2];

public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] num = new int[s.length()+1];
        num[0] = 1;
        if(isValid(s.substring(0,1))){
            num[1] = 1;
        }
        else{
            num[1] = 0;
        }
        for(int i=2; i<=s.length(); i++){
            if(isValid(s.substring(i-1,i))){
                num[i] += num[i-1];
            }
            if(isValid(s.substring(i-2,i))){
                num[i] += num[i-2];
            }
        }
        return num[s.length()];
    }
    public boolean isValid(String s){
        // check the first character, if its 0, its invalid
        if(s.charAt(0)=='0') return false;
        if(Integer.parseInt(s)>0 && Integer.parseInt(s)<=26){
            return true;
        }
        return false;
    }
}