/** Repeated DNA Sequences **/
/*==========================================================================================================================
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
==========================================================================================================================*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null||s.length()<10) return new ArrayList<String>();
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        hm.put('A',0);
        hm.put('C',1);
        hm.put('G',2);
        hm.put('T',3);
        
        HashSet<Integer> temp = new HashSet<Integer>();
        HashSet<Integer> added = new HashSet<Integer>();
        List<String> res = new ArrayList<String>();
        int hash = 0;
        for(int i=0; i<s.length(); i++){
            if(i<9){
                hash = (hash<<2)+hm.get(s.charAt(i));
            }
            else{
                hash = (hash<<2)+hm.get(s.charAt(i));
                // 20 bits 
                hash = hash&((1<<20)-1);
                if(temp.contains(hash)&&!added.contains(hash)){
                    added.add(hash);
                    res.add(s.substring(i-9,i+1));
                }
                else{
                    temp.add(hash);
                }
                
            }
        }
        
        return res;
    }
}