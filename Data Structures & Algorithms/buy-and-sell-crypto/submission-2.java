class Solution {
    public int maxProfit(int[] prices) {
        int currMaxPrice = 0;

        int left = 0;
        int right = 1;
        while(right < prices.length) {

            currMaxPrice = Math.max(currMaxPrice, prices[right] - prices[left]);
            
            if(prices[right] > prices[left]) {
                right++;
            } else {
                left = right;
                right++;
            }
        }

        return currMaxPrice;
    }
}
