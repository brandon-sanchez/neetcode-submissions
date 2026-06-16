class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1] * len(nums)

        # prefix
        prefix = 1
        for i in range(len(nums)):
            result[i] = prefix
            prefix *= nums[i] 

        # postfix
        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
           result[i] *= postfix
           postfix *= nums[i]

        # output
        return result