/** Edit Distance **/
/*==================================================================================================
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
==================================================================================================*/
//  这道题用二维数列的解法
// 动态规划
public class Solution {
    public int minDistance(String word1, String word2) {
        // dp for converting
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // initialize dp
        for(int i=0; i<=word1.length(); i++){
            dp[i][0] = i;
        }
        int min;
        for(int i=0; i<=word2.length(); i++){
            dp[0][i] = i;
        }
        // 
        for(int i=0; i<word1.length(); i++){
            char c1 = word1.charAt(i);
            for(int j=0; j<word2.length(); j++){
                char c2 = word2.charAt(j);
                if(c1==c2){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
                    int replace = dp[i][j]+1;
                    int delete = dp[i+1][j]+1;
                    int insert = dp[i][j+1]+1;
                    min = Math.min(insert,delete);
                    min = Math.min(min,replace);
                    dp[i+1][j+1] = min;
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}