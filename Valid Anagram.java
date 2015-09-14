/** Valid Anagram **/
/*=================================================================================== 
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

======================================================================================*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }
            else{
                hm.put(s.charAt(i),1);
            }
        }
        
        for(int i=0; i<t.length(); i++){
            if(hm.containsKey(t.charAt(i))){
                if(hm.get(t.charAt(i))<=0) return false;
                else{
                    hm.put(t.charAt(i),hm.get(t.charAt(i))-1);
                }
            }
            else{
                return false;
            }
        }
        
        return true;
        
    }
}