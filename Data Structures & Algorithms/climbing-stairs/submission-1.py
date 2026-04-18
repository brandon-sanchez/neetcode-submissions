class Solution:
    def dfs(n, i):
        if i >= n:
            return i == n
        
        return dfs(n, i + 1) + dfs(n, i + 2)


    def climbStairs(self, n: int) -> int:
        return dfs(n, 0)