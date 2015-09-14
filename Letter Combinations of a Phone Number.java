/** Letter Combinations of a Phone Number **/
/*==============================================================================================
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
==============================================================================================*/
// iterative version
public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> hm = new HashMap<Character,String>();
        if(digits.length()==0) return new ArrayList<String>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        LinkedList<String> res = new LinkedList<String>();
        res.add("");
        for(int i=0; i<digits.length(); i++){
            String s = hm.get(digits.charAt(i));
            int size = res.size();
            for(int j=0; j<size; j++){
                String temp = res.pop();
                for(int k=0; k<s.length(); k++){
                    res.add(temp+s.charAt(k));
                }
            }
        }
        List<String> rec = new LinkedList<String>();
        rec.addAll(res);
        return rec;
        
        
    }
    
    
}

// revursive version
public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        HashMap<Character,String> hm = new HashMap<Character,String>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        helper(digits,0,hm,"",res);
        return res;
    }
    
    public void helper(String digits,int number,HashMap<Character,String> hm,String temp, List<String> res){
        if(number==digits.length()){
            res.add(temp);
            return;
        }
        String s = hm.get(digits.charAt(number));
        for(int i=0; i<s.length(); i++){
            temp = temp + s.charAt(i);
            helper(digits,number+1,hm,temp,res);
            temp = temp.substring(0,temp.length()-1);
        }
    }
}