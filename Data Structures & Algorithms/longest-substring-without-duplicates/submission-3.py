class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        left = 0
        right = 0

        my_set = set()

        max_length = 0

        while right < len(s):
            
            while s[right] in my_set:
                my_set.remove(s[left])
                left += 1
            
            my_set.add(s[right])
            max_length = max(max_length, right - left + 1)
            right += 1
        
        return max_length