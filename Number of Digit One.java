/** Number of Digit One **/
/*=================================================================================
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
=================================================================================*/

public class Solution {
    public int countDigitOne(int n) {
        int numOfOnes = 0;
        for(long m=1; m<=n; m*=10){
            long a = n/m;
            long b = n%m;
            numOfOnes += (a+8)/10*m;
            if(a%10==1) numOfOnes += b+1;
        }
        
        return numOfOnes;
    }
}