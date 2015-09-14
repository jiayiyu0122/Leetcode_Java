/** Power of Two **/
/*========================================================================
Given an integer, write a function to determine if it is a power of two.
=========================================================================*/
//  solution 1
public class Solution {
    public boolean isPowerOfTwo(int n) {
        String binary = Integer.toBinaryString(n);
        // n must be larger than 0
        if(n<0){
            return false;
        }
        // calculate the number of 1 in the string
        int count = 0;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i)=='1' && count==0){
                count++;
            }
            else if(binary.charAt(i)=='1' && count!=0){
                return false;
            }
        }
        // only 0 
        if(count==0){
            return false;
        }
        return true;
    }
}
// solution 2
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        if(n==0) return false;
        int count = 0;
        for(int i=0; i<32; i++){
            if(((n>>i)&1)==1) count++;
        }
        if(count>1) return false;
        return true;
    }
}