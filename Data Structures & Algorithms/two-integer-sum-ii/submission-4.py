class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        right = 0
        for left in range(len(numbers)):
            right = left

            while right < len(numbers):

                if numbers[left] + numbers[right] == target and numbers[left] != numbers[right]:
                    return [left + 1, right + 1]
                
                right += 1

        return []
