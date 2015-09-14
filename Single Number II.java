/**Single Number II **/
/*============================================================================
Given an array of integers, every element appears three times except for one. Find that single one.
============================================================================*/
// time: o(n), space: o(1)
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        int[] countbits = new int[32];
        for(int i=0; i<32; i++){
            for(int j=0; j<nums.length; j++){
                if(((nums[j]>>i)&1)==1){
                    countbits[i] = (countbits[i]+1)%3;
                }
            }
            
            res |= (countbits[i]<<i);
            
        }
        
        return res;
        
    }
}