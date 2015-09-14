/** Best Time to Buy and Sell Stock II **/
/*===============================================================================================================
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
==============================================================================================================*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int maxProfit = 0;
        int minElement = prices[0];
        int startIndex = 0;
        int i=0; 
        for(i=1; i<prices.length; i++){
            if(prices[i]<prices[i-1]){
                maxProfit += prices[i-1]-prices[startIndex];
                startIndex = i;
            }
        }
        
        // 处理最后一次的profit
        if(prices[i-1]>prices[startIndex]){
            maxProfit += prices[i-1]-prices[startIndex];
        }
        return maxProfit;
    }
}