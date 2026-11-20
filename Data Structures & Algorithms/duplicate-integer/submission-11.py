class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        
        dup_check = []

        for num in nums:
            if num in dup_check:
                return True
            dup_check.append(num)

        return False