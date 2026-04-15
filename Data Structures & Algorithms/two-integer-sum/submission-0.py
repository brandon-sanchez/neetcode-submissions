class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        myArray = {}
        for i, n in enumerate(nums):
            diff = target - n
            if diff in myArray:
                return [myArray[diff], i]
            myArray[n] = i