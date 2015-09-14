/** ZigZag Conversion **/
/*===========================================================================================================================
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
===========================================================================================================================*/
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(s.length()==0) return new String();
        // if(s.length()==1) return s;
        if(numRows==1) return s;
        for(int i=0; i<numRows; i++){
            if(i==0){
                for(int j=0; j<s.length(); j=j+(numRows-1)*2){
                    sb.append(s.charAt(j));
                }
            }
            else if(i==numRows-1){
                for(int j=numRows-1; j<s.length(); j=j+(numRows-1)*2){
                    sb.append(s.charAt(j));
                }
            }
            else{
                int j=i;
                // 向下
                boolean direction = true;
                while(j<s.length()){
                    if(direction==true){
                        sb.append(s.charAt(j));
                        j = j+2*(numRows-1-i);
                        direction = false;
                    }
                    // 向上
                    else{
                        sb.append(s.charAt(j));
                        j = j+2*i;
                        direction = true;
                    }
                    
                }
            }
        }
        
        return sb.toString();
        
        
    }
}