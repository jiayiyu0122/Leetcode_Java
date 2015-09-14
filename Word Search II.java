/** Word Search II **/

/*=================================================================================================
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
=================================================================================================*/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        root = CreateDictionary(root,words); 
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<String>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                HashMap<Character,TrieNode> children = root.hm;
                // char c = board[i][j];
                helper(board,i,j,"",visited,res,children);
                
            }
        }
        
        return res;
        
    }
    
    public void helper(char[][] board,int i, int j, String temp, boolean[][] visited, List<String> res, HashMap<Character,TrieNode> children){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        if(visited[i][j]) return;
        if(children.containsKey(board[i][j])){
            temp += String.valueOf(board[i][j]);
            if(children.get(board[i][j]).isLeaf==true){
                if(!res.contains(temp)){
                    res.add(temp);
                }
            }
            children = children.get(board[i][j]).hm;
            visited[i][j] = true;
            helper(board,i+1,j,temp,visited,res,children);
            helper(board,i,j+1,temp,visited,res,children);
            helper(board,i-1,j,temp,visited,res,children);
            helper(board,i,j-1,temp,visited,res,children);
            visited[i][j] = false;
            return;
            
        }
        else{
            return;
        }
        
    }
    
    public TrieNode CreateDictionary(TrieNode root,String[] words){
        if(words==null || words.length==0) return root;
        for(int i=0; i<words.length; i++){
            HashMap<Character,TrieNode> children = root.hm;
            for(int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                if(!children.containsKey(c)){
                    TrieNode temp = new TrieNode(c);
                    children.put(c,temp);
                }
                if(j==words[i].length()-1){
                    children.get(c).isLeaf = true;
                }
                children = children.get(c).hm;
                
            }
        }
        return root;
    }
}

class TrieNode{
    char c;
    HashMap<Character,TrieNode> hm = new HashMap<Character,TrieNode>();
    boolean isLeaf;
    
    public TrieNode(){
        c = ' ';
        hm = new HashMap<Character,TrieNode>();
        boolean isLeaf = false;
    }
    
    public TrieNode(char c){
        this.c = c;
        hm = new HashMap<Character,TrieNode>();
        boolean isLeaf = false;
    }
}