class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        max_profit = 0

        left = 0
        right = 1

        while right < len(prices):

            print(f"{prices[left]} {prices[right]}")

            
            max_profit = max(max_profit, prices[right] - prices[left])
            
            if prices[left] > prices[right]:
                left = right
        
            right += 1


        
        return max_profit