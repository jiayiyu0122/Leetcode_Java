 /** Add and Search Word - Data structure design **/
/*========================================================================================================
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . 
means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
========================================================================================================*/
public class WordDictionary {
    private TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode t = root;
        for(int i=0; i<word.length(); i++){
            if(t.hm.containsKey(word.charAt(i))){
                t = t.hm.get(word.charAt(i));
            }
            else{
                TrieNode n = new TrieNode(word.charAt(i));
                t.hm.put(word.charAt(i),n);
                t = n;
            }
            if(i==word.length()-1){
                t.isleaf = true;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word,root.hm,0);
        
    }
    
    public boolean dfs(String word,HashMap<Character,TrieNode> children, int index){
        if(index == word.length()){
            if(children.size()==0) 
                return true; 
            else
                return false;
        }
        
        char c = word.charAt(index);
        if(children.containsKey(c)){
            if(index==word.length()-1 && children.get(c).isleaf==true){
                return true;
            }
            return dfs(word,children.get(c).hm,index+1);
        }
        else if(c=='.'){
            boolean result = false;
            for(Map.Entry<Character, TrieNode> child: children.entrySet()){
                if(index == word.length()-1 && child.getValue().isleaf==true){
                    return true;
                } 
 
                //if any path is true, set result to be true; 
                if(dfs(word,child.getValue().hm, index+1)){
                    result = true;
                }
            }
            
            return result;
        }
        return false;
    }
    
}

class TrieNode{
    char val;
    HashMap<Character,TrieNode> hm = new HashMap<Character,TrieNode>();
    boolean isleaf;
    
    public TrieNode(){
        val = ' ';
        hm = new HashMap<Character,TrieNode>();
        isleaf = false;
    }
    
    public TrieNode(char c){
        val = c;
        this.hm = new HashMap<Character,TrieNode>();
        isleaf = false;
    }
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");