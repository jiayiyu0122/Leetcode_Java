/** Permutation Sequence **/
/*====================================================================
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
====================================================================*/
// 这道题目不能用backtracking暴力搜索会超时
// 每个元素的对应剩下的数列的排序是（n-1）！， 所以第一个元素对应的下标是k/(n-1)!，k = k%(n-1)!

public class Solution {
    public String getPermutation(int n, int k) {
        if(n==0 || k==0) return new String();
        k--;
        // factorial
        int factor = 1;
        for(int i=2; i<n; i++){
            factor *= i;
        }
        // arraylist n
        ArrayList<Integer> originalList = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            originalList.add(i);
        }
        
        //main algorithm part
        int round = n-1;
        StringBuilder res = new StringBuilder();
        while(round>=0){
            int index = k/factor;
            k %= factor;
            res.append(originalList.get(index));
            originalList.remove(index);
            if(round>0){
                factor = factor/round;
            }
            round--;
        }
        return res.toString();
    }
        
}