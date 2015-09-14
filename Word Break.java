/** Word Break **/
/*==================================================================
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
==================================================================*/

// 动态规划1
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int slen = s.length();
        boolean[] wbArray = new boolean[slen+1];
        // initialize wbArray
        for (int i=0; i<slen+1; i++){
            wbArray[i] = false;
        }
        
        for(int i=0; i<slen; i++){
            // if wordDict contains substring[0:i], set true
            if(wordDict.contains(s.substring(0,i+1))){
                wbArray[i+1] = true;
            }
            // or check if it is space seperated by the dictionary
            else{
                for(int j=0; j<i+1; j++){
                    if(wbArray[j] == true){
                        if(wordDict.contains(s.substring(j,i+1))){
                            wbArray[i+1] = true;
                            break;
                        }
                    }
                
                }
                
            }
            
        }
        return wbArray[slen];
        
    }
}

// 动态规划2
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        // 前i个字符
        for(int i=1; i<s.length()+1; i++){
            // 长度
            canBreak[i] = false;
            
            for(int j=1;j<=i; j++){
                if(!canBreak[i-j]){
                    continue;
                }
                if(isWord(s,i-j,i-1,wordDict)==true){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[s.length()];
    }
    
    public boolean isWord(String s, int start, int end, Set<String> wordDict){
        String sub = s.substring(start,end+1);
        if(wordDict.contains(sub)){
            return true;
        }
        
        return false;
        
    }
}
// 超时
public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length()==0) return false;
        return helper(s,wordDict);
    }
    
    public boolean helper(String s, Set<String> wordDict){
        if(s.length()==0){
            return true;
        }
        for(int i=0; i<s.length(); i++){
            String temp = s.substring(0,i+1);
            if(wordDict.contains(temp)){
                if(helper(s.substring(i+1),wordDict)){
                    return true;
                }
            }
        }
        return false;
    }