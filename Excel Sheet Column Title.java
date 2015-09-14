/** Excel Sheet Column Title  **/
/*==================================================================================================
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

==================================================================================================*/
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        String[] s = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        
        while(n>26){
            int rem = n%26;
            if(rem==0){
                rem = 26;
                n = n/26-1;
            }
            else{
               n = n/26; 
            }
            
            res.append(s[rem-1]);
        }
        res.append(s[n-1]);
        return res.reverse().toString();
    }
}