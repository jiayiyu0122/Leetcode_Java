/* Palindrome Partitioning II */
/*=======================================================================================
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
=======================================================================================*/
public class Solution {
    public boolean isPalindrome(String s){
        if(s.length()==1) return true;
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean[][] PanlindromeMatrix(String s){
        boolean[][] matrix = new boolean[s.length()][s.length()];
        // 长度为1的字符串
        for(int i=0; i<s.length(); i++){
            matrix[i][i] = true;
        }
        // 长度为2的字符串
        for(int i=0; i<s.length()-1; i++){
            matrix[i][i+1] = (s.charAt(i)==s.charAt(i+1));
        }
        // 长度大于二的字符串
        for(int length=2; length<s.length(); length++){
            for(int start=0; start+length<s.length(); start++){
                matrix[start][start+length] = matrix[start+1][start+length-1]&&(s.charAt(start)==s.charAt(start+length));
            }
        }
         
        
        return matrix;
    }
    public int minCut(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 0;
        }
        // dp array
        // cut[i] means the number of cuts from [0,i-1]
        int[] cut = new int[s.length()+1];
        boolean[][] matrix = PanlindromeMatrix(s);
        cut[0]=-1;
        for(int i=1; i<=s.length(); i++){
            cut[i] = Integer.MAX_VALUE;
            for(int j=1; j<=i; j++){
                if(matrix[i-j][i-1]){
                    cut[i] = Math.min(cut[i-j]+1,cut[i]);
                }
            }
        }
        return cut[s.length()];
    }
    
    
        
    } 
    
