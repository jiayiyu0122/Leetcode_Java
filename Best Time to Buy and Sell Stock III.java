/** Best Time to Buy and Sell Stock III  **/

/*=========================================================================================
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

=========================================================================================*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        // 二分法
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        helper(left,right,prices);
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            maxProfit = Math.max(maxProfit,left[i]+right[i]);
        }
        
        return maxProfit;
    }
    
    public void helper(int[] left, int[] right, int[] prices){
        left[0] = 0;
        int minPrice = prices[0];
        for(int i=1; i<left.length; i++){
            left[i] = Math.max(left[i-1],prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        
        right[prices.length-1] = 0;
        int maxPrice = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--){
            right[i] = Math.max(right[i+1],maxPrice-prices[i]);
            maxPrice = Math.max(maxPrice,prices[i]);
        }
        
    }
    
    
}