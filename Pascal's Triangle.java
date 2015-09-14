/** Pascal's Triangle **/
/*======================================================================
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
======================================================================*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0) return res;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        for(int i=1; i<numRows; i++){
            List<Integer> cur = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j-1>=0 && j<=i-1){
                    cur.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
                else if(j-1<0){
                    cur.add(res.get(i-1).get(j));
                }
                else{
                    cur.add(res.get(i-1).get(j-1));
                }
                
            }
            res.add(cur);
        }
        
        return res;
    }
}