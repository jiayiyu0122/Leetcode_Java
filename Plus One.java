/** Plus One **/
/*=======================================================================================
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
=======================================================================================*/
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i=0; i<digits.length; i++){
            if(digits[i]!=9){
                flag = false;
                break;
            }
        }
        int[] res;
        if(flag==true){
             res = new int[digits.length+1];
        }
        else{
            res = new int[digits.length];
        }
        
        
        int carry = 0;
        for(int i=digits.length-1, j=res.length-1; i>=0; i--,j--){
            if(i==digits.length-1){
                res[j] = (digits[i]+1)%10;
                carry = (digits[i]+1)/10;
            }
            else{
                res[j] = (carry+digits[i])%10;
                carry = (carry+digits[i])/10;
            }
        }
        
        if(carry==1){
            res[0]=1;
        }
        return res;
    }
}