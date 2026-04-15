class Solution {
    public int maxProfit(int[] prices) {
       int left = 0;
       int right = 1;

       int currentMaxProfit = 0;
       while (right < prices.length) {
        if(prices[left] < prices[right]) {
            int profit = prices[right] - prices[left];
            currentMaxProfit = Math.max(currentMaxProfit, profit);
        } else {
            left = right;
        }
        right++;
       }

       return currentMaxProfit;
    }
}
