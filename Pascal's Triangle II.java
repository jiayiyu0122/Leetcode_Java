/** Pascal's Triangle II **/
/*==============================================================
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
==============================================================*/
//this solution optimized algorithm to  use only O(K) estra space
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if(rowIndex==0) return res;
        for(int i=1; i<=rowIndex; i++){
            List<Integer> temp = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0){
                    temp.add(res.get(j));
                }
                else if(j==i){
                    temp.add(res.get(j-1));
                }
                else{
                    temp.add(res.get(j-1)+res.get(j));
                }
                
            }
            res = temp;
        }
        
        return res;
    }
}