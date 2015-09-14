/** Wildcard Matching **/
/*=====================================================================
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
=====================================================================*/
// 难题
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0; i<p.length(); i++){
                if(p.charAt(i)!='*'){
                    for(int j=s.length()-1; j>=0; j--){
                        res[j+1] = res[j]&&(s.charAt(j)==p.charAt(i)||p.charAt(i)=='?');
                    }
                    
                }
                else{
                    int j=0;
                    while(j<=s.length() && res[j]==false){
                        j++;
                    }
                    while(j<=s.length()){
                        res[j] = true;
                        j++;
                    }
                }
            
                res[0] = res[0]&&p.charAt(i)=='*';
        }
        return res[s.length()];
    }
}