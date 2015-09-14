public class Solution {
    public String longestPalindrome(String s) {
        String t = "&#";
        for(int i=0; i<s.length(); i++){
            t = t+s.charAt(i)+'#';
        }
        t = t+'$';
        int tLen = t.length();
        int[] p = new int[tLen];
        int right = 0, left = 0, center = 0, MaxLength = 0;
        for(int i=1; i<tLen-1; i++){
            if(i<right){
                p[i] = Math.min(p[2*center-i],right-i);
            }
            while(t.charAt(i+p[i]+1)==t.charAt(i-p[i]-1)){
                ++p[i];
            }
            if (p[i]+i > right){
                center = i;
                right = center + p[i];
               
            }
            if(p[i] > MaxLength){
                MaxLength = p[i];
                left = i- p[i];
            }
        }
        
        s = s.substring((left-1)/2,(left-1)/2+MaxLength);
        return s;
 }
}