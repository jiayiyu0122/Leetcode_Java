/* Excel Sheet Column Number */
/*===========================================================================================
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
===========================================================================================*/
public class Solution {
    public int titleToNumber(String s) {
        if(s.length()==0) return 0;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        char c = 'A';
        for(int i=1; i<=26; i++){
            hm.put(c,i);
            c++;
        }
        
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum = sum*26 + hm.get(s.charAt(i));
        }
        
        return sum;
        
    }
}