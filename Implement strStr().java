/** Implement strStr() **/
/*======================================================================================================
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
======================================================================================================*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0&&needle.length()==0) return 0;
        if(needle.length()==0) return 0;
        if(haystack.length()<needle.length()) return -1;
        int nLen = needle.length();
        for(int i=0; i<=haystack.length()-nLen; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(i+nLen<=haystack.length()&&haystack.substring(i,i+nLen).equals(needle)){
                    return i;
                }
            }
        }
        
        return -1;
    }
}