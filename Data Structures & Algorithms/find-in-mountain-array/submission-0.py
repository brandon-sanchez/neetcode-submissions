class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        left = 1
        right = mountainArr.length() - 2

        while (left <= right):
            m = (left + right) // 2

            left, mid, right = mountainArr.get(m - 1) , mountainArr.get(m), mountainArr.get(m + 1)

            if left < mid < right:
                left = m + 1
            elif left > mid > right:
                right = m - 1
            else:
                peak = m
                break

        left = 0
        right = peak - 1

        while left <= right:
            m = (left + right) // 2

            val = mountainArr.get(m)
            if val < target:
                left = m + 1
            elif val > target:
                right = m - 1
            else:
                return m
        
        left = peak
        right = mountainArr.length() - 1

        while left <= right:
            m = (left + right) // 2
            
            val = mountainArr.get(m)
            if val < target:
                left = m + 1
            elif val > target:
                right = m - 1
            else:
                return m

        return -1