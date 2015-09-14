/** Reverse Integer **/
/*=================================
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
=================================*/

public class Solution {
    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean positive = (x > 0) ? true : false;
        long result = 0;
        x = Math.abs(x);
        while(x > 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE){
            return 0;
        }
        if(!positive){
            result *= -1;
        }
        return (int)result;
    }
}