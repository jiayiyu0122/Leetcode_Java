
import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){ val = x; }; 
}

public class Solution {
	public static List<String> addOperators(String num){
		List<String> res = new ArrayList<String>();
		addOperators(num,"",res,num.length());
		return res;
    }
	
	public static void addOperators(String num, String s,List<String> res,int length){
		if(s.length()==length){
			res.add(s);
		}
		for(int i=0; i<num.length(); i++){
			
			if(num.charAt(i)!='?'){
				s += num.charAt(i);
				if(s.length()==length){
					res.add(s);
					System.out.println(s);
				}
			}
			else{
				addOperators(num.substring(i+1),s+'J',res,length);
				addOperators(num.substring(i+1),s+'K',res,length);
			}
		}
	}
	
	
    public static void main(String[] args){
//    	s = "catsanddog",
//    	dict = ["cat", "cats", "and", "sand", "dog"].
    	String s = "ab?j?k";
    	List<String> res = new ArrayList<String>();
    	res = addOperators(s);
    	String[] temp = new String[res.size()];
    	temp = res.toArray(temp);
    	System.out.println(Arrays.toString(temp));
    	
    }

}

public class Solution {
    
    public static List<String> replaceWithNewChar(String s, int index, List<String> res){
        for(int i=index; i<s.length(); i++){
            if(s.charAt(i)=='?'){
                String temp = s.substring(0,i)+'J'+s.substring(i+1);
                replaceWithNewChar(temp, i,res);
                temp = s.substring(0,i)+'K'+s.substring(i+1);
                replaceWithNewChar(temp,i,res);
                break;
            }
            else if(index==s.length()-1){
                System.out.println(s);
                res.add(s);
                
            }
            
        }
        
        return res;
        
    }