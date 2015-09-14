/** Length of Last Word **/
/*====================================================================================
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
====================================================================================*/
public class Solution {
    // a-z:97-122 A-Z:65-90
    public int lengthOfLastWord(String s) {
        int count = 0;
        // find the last character that is not space
        int i=s.length()-1;
        for(; i>=0; i--){
            if(s.charAt(i)==' '){
                continue;
            }
            else{
                break;
            }
        }
        if(i<0) return count;
        for(int j=i; j>=0; j--){
            if(s.charAt(j)>='a' && s.charAt(j)<='z' || s.charAt(j)>='A' && s.charAt(j)<='Z'){
                count++;
            }
            else if(s.charAt(j)==' '){
                return count;
            }
        }
        
        return count;
    }
}