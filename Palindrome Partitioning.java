/** Palindrome Partitioning **/
/*===========================================================================================
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 ============================================================================================*/
public class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        if(s.length()==0) return res;
        ArrayList<String> temp = new ArrayList<String>();
        helper(s,temp,res);
        return res;
    }
    
    public void helper(String s, ArrayList<String> temp, ArrayList<List<String>> res){
        if(s.length()==0){
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=1; i<=s.length(); i++){
            String cur = s.substring(0,i);
            if(isPalindrome(cur)){
                temp.add(cur);
                helper(s.substring(i),temp,res);
                temp.remove(temp.size()-1); 
            }
        }
    }
    
    public boolean isPalindrome(String s){
        if(s.length()==0) return true;
        if(s.length()==1) return true;
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}