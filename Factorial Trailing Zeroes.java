/** Factorial Trailing Zeroes **/
/*================================================================
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

================================================================*/
public class Solution {
// 能被5除进得数
    public int trailingZeroes(int n) {
        if(n<0) return 0;
        int count = 0;
        for(long i=5; n/i>=1; i*=5){
            count += n/i;
        }
        
        return count;
    }
    
    
}