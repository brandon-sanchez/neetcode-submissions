class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int currMaxProfit = 0;

        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                currMaxProfit = Math.max(profit, currMaxProfit);
            } else {
                left = right;
            }
            right++;
        }

        return currMaxProfit;
    }
}
