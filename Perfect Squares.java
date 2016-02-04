/** Perfect Squares **/
/**=======================================================================================Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
=======================================================================================**/
// 超时
// 先找出perdectsquare list，再用backtrack的方法
public class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSquare = new ArrayList<Integer>();
        int i = 1;
        while(i<=n){
            if(i*i<=n){
                perfectSquare.add(i*i);
                i++;
            }
            else{
                break;
            }
        }
        int[] minLength = {Integer.MAX_VALUE};
        helper(n, 0, perfectSquare, 0, minLength);
        return minLength[0];
    }
    
    public void helper(int target, int index, List<Integer> perfectSquare, int temp, int[] minLength){
        if(target==0){
            minLength[0] = Math.min(minLength[0], temp);
            return;
        }
        
        for(int i=index; i<perfectSquare.size(); i++){
            if(perfectSquare.get(i)<=target){
                temp += 1;
                helper(target-perfectSquare.get(i), index,perfectSquare, temp, minLength);
                temp -= 1;
            }
        }
        return;
    }
}

// 动态规划
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=1; i*i<=n; i++){
            dp[i*i] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; i+j*j<=n; j++){
                dp[i+j*j] = Math.min(dp[i]+1, dp[i+j*j]);
            }
        }
        return dp[n];
    }
}