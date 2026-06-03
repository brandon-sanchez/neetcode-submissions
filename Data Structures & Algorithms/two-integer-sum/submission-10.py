class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        # Key: Number Value: Index
        my_dict = {}
        
        for i in range(len(nums)):
            numToFind = target - nums[i]

            if numToFind in my_dict:
                return [my_dict[numToFind], i]
            
            my_dict[nums[i]] = i