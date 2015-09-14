/** Restore IP Addresses **/
/*=============================================================================================================
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
=============================================================================================================*/
// 这道题用暴力回溯法

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4 || s.length()>12) return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        helper(s,"",0,res);
        return res;
        
    }
    public void helper(String s, String temp, int count, List<String> res){
        if(count==3 && isValid(s)){
            res.add(temp+s);
        }
        for(int i=1; i<4 && i<s.length(); i++){
            String cur = s.substring(0,i);
            if(isValid(cur)){
                helper(s.substring(i),temp+cur+".",count+1,res);
            }
            else return;
            
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0)=='0'&& s.length()>1) return false;
        if(Integer.parseInt(s)>255 || Integer.parseInt(s)<0){
            return false;
        }
        return true;
    }
}