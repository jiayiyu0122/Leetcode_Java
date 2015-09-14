/* Fraction to Recurring Decimal */

/*=================================================================================================
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
=================================================================================================*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return ""; 
        HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
        String ans = "";
        // determine if result is negative
        if((numerator<0 && denominator>0) || (numerator>0 && denominator<0)){
            ans += "-";
        }
        // convert to nums larger than zero;
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        // determine if its terminating number
        long reminder = (num%den)*10;
        ans += String.valueOf(num/den);
        if(reminder==0) return ans;
        // determine the part after '.'
        ans += ".";
        while(reminder!=0){
            if(hm.containsKey(reminder)){
                int begin = hm.get(reminder);
                String part1 = ans.substring(0,begin);
                String part2 = ans.substring(begin);
                ans = part1 + "(" + part2 + ")";
                return ans;
            }
            else{
                hm.put(reminder,ans.length());
                ans += String.valueOf(reminder/den);
                reminder = (reminder%den)*10;
            }
        }
        
        return ans;
    }
}