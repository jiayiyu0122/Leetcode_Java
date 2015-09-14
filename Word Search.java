/** Word Search **/
/*========================================================================================================================
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
========================================================================================================================*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean res = false;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(dfs(board,i,j,0,word,visited)){
                    return true;
                }
            }
        }
        return res;
        
    }
    
    public boolean dfs(char[][] board, int i, int j, int index, String word,boolean[][] visited){
        if(index==word.length()){
            return true;
        }
        if(i<0||j<0||i>board.length-1||j>board[0].length-1){
            return false;
        }
        
        if(word.charAt(index)!=board[i][j]){
            return false;
        }
        
        
        if(visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board,i+1,j,index+1,word,visited)||dfs(board,i-1,j,index+1,word,visited)||dfs(board,i,j-1,index+1,word,visited)||dfs(board,i,j+1,index+1,word,visited);
        visited[i][j] = false;
        return res;
    }
}