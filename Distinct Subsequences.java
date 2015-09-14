/** Distinct Subsequences **/
/*==================================================================================
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
==================================================================================*/
// 动态规划
//Let W(i, j) stand for the number of subsequences of S(0, i) equals to T(0, j). 
// If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j); 
//Otherwise, W(i, j) = W(i-1,j).
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] numOfSub = new int[s.length()+1][t.length()+1];
        for(int i=0; i<s.length(); i++){
            numOfSub[i][0] = 1;
        }
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=t.length(); j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    numOfSub[i][j] = numOfSub[i-1][j-1]+numOfSub[i-1][j];    
                }
                else{
                    numOfSub[i][j] = numOfSub[i-1][j];                   
                }
                
            }
        }
        return numOfSub[s.length()][t.length()];
    }
}