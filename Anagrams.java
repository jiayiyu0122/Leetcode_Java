import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
      
        Hashtable<String, ArrayList<String>> anaHashtable = new Hashtable<String, ArrayList<String>>();
        ArrayList<String> ret = new ArrayList<String>();
        for(int i=0; i<strs.length; i++){
            String temp = sorted(strs[i]);
            ArrayList<String> value = anaHashtable.get(temp);
            //check if the sorted string is in the hastable
            if(value != null){
                value.add(strs[i]);
            }
            else{
                value = new ArrayList<String>();
                value.add(strs[i]);
                anaHashtable.put(temp, value);
            }
        }
            // iterate all the key and value pairs in the hastable
            Set<String> keys = anaHashtable.keySet();
            for(String key : keys){
                ArrayList<String> value = anaHashtable.get(key);
                if(value.size() > 1){
                    ret.addAll(value);
                }
            }
        
        return ret;
        
    }
    public String sorted(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}