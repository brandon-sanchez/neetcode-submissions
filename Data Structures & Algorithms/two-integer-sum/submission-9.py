class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Key: Index value, Value = Index
        my_dict = {}

        for i, num in enumerate(nums):
            difference = target - nums[i]

            if difference in my_dict.keys():
                return [my_dict[difference], i]
            
            my_dict[num] = i
        
        return []