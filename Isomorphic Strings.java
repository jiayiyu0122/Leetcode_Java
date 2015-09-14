/** Isomorphic Strings **/
/*===============================================================================================================
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
===============================================================================================================*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Hashtable<String, String> isoTable1 = new Hashtable<String, String>();
        Hashtable<String, String> isoTable2 = new Hashtable<String, String>();
        // two hashtable method
        // algorithm complexity O(n)
        for(int i=0; i<s.length(); i++){
            
            String temp1 = Character.toString(s.charAt(i));
            String val1 = isoTable1.get(temp1);
            String temp2 = Character.toString(t.charAt(i));
            String val2 = isoTable2.get(temp2);
            
            if(val1 != null){
                if(temp2.equals(val1)){ continue; }
                else{ return false; }
            }
            else{
                if(val2 != null){ return false; }
                else{
                    isoTable1.put(temp1, temp2);
                    isoTable2.put(temp2, temp1);
                }
            }
        }
        
        return true;
    }
    
}

public static boolean check(String s,String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map1=new HashMap<Character, Character>();
        HashMap<Character,Character> map2=new HashMap<Character, Character>();
        
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map1.containsKey(c1)){
                if(map1.get(c1)!=c2) return false;
            }
            if(map2.containsKey(c2)){
                if(map2.get(c2)!=c1) return false;
            }
            
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }