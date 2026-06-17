class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        num_set = set()
        longest = 0
        streak = 0
        for num in nums:
            num_set.add(num)

        
        for num in nums:
            while num in num_set:
                streak += 1
                longest = max(longest, streak)
                num += 1
            
            streak = 0

        return longest