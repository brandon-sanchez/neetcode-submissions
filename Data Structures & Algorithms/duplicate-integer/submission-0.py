class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        emptySet = set()
        for index in nums:
            if index in emptySet:
                return True
            emptySet.add(index)
        return False

         