/** Scramble String **/
/*==========================================================================================
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
==========================================================================================*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
    // 这道题用dp的方法做是O(n^3)
    // 用递推来写是O(3^n)
    // 递推
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] array1 = s1.toCharArray();
        Arrays.sort(array1);
        String s11 = new String(array1);
        
        char[] array2 = s2.toCharArray();
        Arrays.sort(array2);
        String s22 = new String(array2);
        
        if(!s11.equals(s22)){
            return false;
        }
        
        int len = s1.length();
        if(len==1){
            return s1.equals(s2);
        }
        for(int i=1; i<len; i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i,len),s2.substring(i,len))){
                return true;
            }
            if(isScramble(s1.substring(0,i),s2.substring(len-i,len))&&isScramble(s1.substring(i,len),s2.substring(0,len-i))){
               return true; 
            }
        }
        
        return false;
        
        
    }
    
    


}