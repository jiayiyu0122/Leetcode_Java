/** Interleaving String **/
/*============================================================================
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
============================================================================*/
// 动态规划
// matched[l1][l2] = s1[l1-1] == s3[l1+l2-1] && matched[l1-1][l2] || s2[l2 - 1] == s3[l1+l2-1] && matched[l1][l2-1]

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] match = new boolean[s1.length()+1][s2.length()+1];
        match[0][0] = true;
        for(int i=1; i<=s1.length(); i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)){
                match[i][0] = true;
            }
            else break;
        }
        
        for(int i=1; i<=s2.length(); i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)){
                match[0][i] = true;
            }
            else  break;
        }
        
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    match[i][j] = match[i-1][j];
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                    match[i][j] |= match[i][j-1];
                }
            }
        }
        
        return match[s1.length()][s2.length()];
        
    }
}