/** Minimum Window Substring **/
/*========================================================================================
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
========================================================================================*/
public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i=0; i<t.length(); i++){
            if(hm.containsKey(t.charAt(i))){
                hm.put(t.charAt(i),hm.get(t.charAt(i))+1);
            }
            else{
                hm.put(t.charAt(i),1);
            }
        }
        int start = 0;
        int last = 0;
        int count = 0;
        int minLen = s.length()+1;
        int minStart = 0;
        for(last=0; last<s.length(); last++){
            if(hm.containsKey(s.charAt(last))){
                hm.put(s.charAt(last),hm.get(s.charAt(last))-1);
                if(hm.get(s.charAt(last))>=0){
                    count++;
                }
                while(count == t.length()){
                    if(last-start+1<minLen){
                        minLen = last-start+1;
                        minStart = start;
                    }
                    if(hm.containsKey(s.charAt(start))){
                        hm.put(s.charAt(start),hm.get(s.charAt(start))+1);
                        if(hm.get(s.charAt(start))>0){
                            count--;
                        }
                        
                    }
                    start++;
                }
            }
        }
        
        if(minLen>s.length()){
            return "";
        }
        return s.substring(minStart,minStart+minLen);
    }
}