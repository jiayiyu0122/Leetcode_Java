/** Count and Say **/
/*==========================================================================
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
==========================================================================*/
public class Solution {
    public String countAndSay(int n) {
        String[] res = new String[n+1];
        res[1] = "1";
        for(int i=2; i<=n; i++){
            String cur = res[i-1];
            char pre = cur.charAt(0);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<cur.length(); j++){
                if(cur.charAt(j)==pre){
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(pre);
                    pre = cur.charAt(j);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(pre);
            res[i] = sb.toString();
        }
        
      return res[n];  
    }
}