/** Gray Code **/
/*==================================================================================================================
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
==================================================================================================================*/
// n位的gray code是n-1的gray code 加上前面加一位1的gray code
public class Solution {
    public List<Integer> grayCode(int n) {
        if(n==0){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(0);
            return temp;
        }        
        List<Integer> res = new ArrayList<Integer>();
        res = grayCode(n-1);
        int index = 1<<n-1;
        for(int i=res.size()-1; i>=0; i--){
            res.add(res.get(i)+index);
        }
        return res;
    }

}