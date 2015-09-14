/** Valid Palindrome **/
/*====================================================================================================
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
====================================================================================================*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='0'&&s.charAt(i)<='9')){
                i++;
            }
            else if(!(s.charAt(j)>='a'&&s.charAt(j)<='z'||s.charAt(j)>='A'&&s.charAt(j)<='Z'||s.charAt(j)>='0'&&s.charAt(j)<='9')){
                j--;
            }
            
            else{
                if(s.charAt(i)==s.charAt(j)){
                    i++;
                    j--;
                }
                else if(s.charAt(i)+32==s.charAt(j)){
                    i++;
                    j--;
                }
                else if(s.charAt(i)-32==s.charAt(j)){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
        }
        
        return true;
    }
}