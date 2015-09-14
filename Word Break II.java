/** Word Break II **/
/*=============================================================================================================================
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
=============================================================================================================================*/
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
    ArrayList<String> res = new ArrayList<String>();
    if(s==null || s.length()==0)
        return res;
    boolean flag = false;
    // 极端的TLE case aaaaaaaaaaaaaaaa.......b, ["aa","aaa","ba"];
    // 先要进行判断剪枝，从后往前，如果扫描以后没有发现有对应的字符串，则返回false.
    for(int i=s.length()-1; i>=0; i--){
        if(dict.contains(s.substring(i))){
            flag = true;
            break;
        }
    }
    if(flag==false){
        return res;
    }
    
    
    helper(s,dict,0,"",res);
    return res;
}
private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res)
{
    if(start>=s.length())
    {
        res.add(item);
        return;
    }
    StringBuilder str = new StringBuilder();
    for(int i=start;i<s.length();i++)
    {
        str.append(s.charAt(i));
        if(dict.contains(str.toString()))
        {
            String newItem = item.length()>0?(item+" "+str.toString()):str.toString();
            helper(s,dict,i+1,newItem,res);
        }
    }
}
}