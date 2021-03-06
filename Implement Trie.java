/** Implement Trie (Prefix Tree) **/
/*======================================================================
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
======================================================================*/

class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isEnd;
    LinkedList<TrieNode> children;
    
    public TrieNode() {
        this.val = ' ';
        this.isEnd = false;
        this.children = new LinkedList<TrieNode>();
    }
    
    public TrieNode(char c){
        this.val = c;
        this.isEnd = false;
        this.children = new LinkedList<TrieNode>();
    }
    public TrieNode subNode(char c){
        if(children!=null){
            for(TrieNode t: children){
                if(t.val==c) return t;
            }
        }
        return null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word)) return;
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            TrieNode temp = cur.subNode(word.charAt(i));
            if(temp==null){
                cur.children.add(new TrieNode(word.charAt(i)));
                temp = cur.subNode(word.charAt(i));
            }
            cur = temp;
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            TrieNode temp = cur.subNode(word.charAt(i));
            if(temp==null) return false;
            cur = temp;
        }
        
        // 判断这个词是否是一个单词
        if(cur.isEnd) return true;
        return false;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++){
            TrieNode temp = cur.subNode(prefix.charAt(i));
            if(temp==null) return false;
            cur = temp;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");