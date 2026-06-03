class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        # Key: Number Value: Index
        hashmap = {}
        
        for i in range(len(nums)):
            numToFind = target - nums[i]

            if numToFind in hashmap:
                return [hashmap[numToFind], i]
            
            hashmap[nums[i]] = i