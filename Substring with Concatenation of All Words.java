/** Substring with Concatenation of All Words **/
/*=======================================================================================================
You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
=======================================================================================================*/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words==null || words.length==0) return res;
        int numOfWord = words.length;
        int wordLen = words[0].length();
        if(s.length()<wordLen*numOfWord) return res;
        // 建立hashmap
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for(int i=0; i<numOfWord; i++){
            if(hm.containsKey(words[i])){   
                hm.put(words[i],hm.get(words[i])+1);
            }
            else{
                hm.put(words[i],1);
            }
        }
        // 
       
        
        HashMap<String,Integer> curMap = new HashMap<String,Integer>();
        int maxIndex = s.length()-words[0].length()+1;
        for(int i=0; i<words[0].length(); i++){
            int count = 0;
            int start = i;
            curMap.clear();
            for(int end=start; end<maxIndex; end+=words[0].length()){
                String str = s.substring(end,end+words[0].length());
                if(!hm.containsKey(str)){
                    start = end+words[0].length();
                    count = 0;
                    curMap.clear();
                    continue;
                }
                else{
                    if(!curMap.containsKey(str)){
                        curMap.put(str,1);
                    }
                    else{
                        curMap.put(str,curMap.get(str)+1);
                    }
                    if(curMap.get(str)<=hm.get(str)){
                        count++;
                    }
                    else{
                        while(curMap.get(str)>hm.get(str)){
                            String tempStr = s.substring(start,start+words[0].length());
                            curMap.put(tempStr,curMap.get(tempStr)-1);
                            if(curMap.get(tempStr)<hm.get(tempStr)){
                                count--;
                            }
                            start += words[0].length();
                        }
                    }
                    if(count==words.length){
                        res.add(start);
                        String tempStr = s.substring(start,start+words[0].length());
                        curMap.put(tempStr,curMap.get(tempStr)-1);
                        count--;
                        start += words[0].length();
                    }
                    
                }
                
            }        
        }
        
        return res;
    }
        
        
    
}