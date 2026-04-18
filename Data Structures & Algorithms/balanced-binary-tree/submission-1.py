# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
       return dfs(root)[0]
        
    def dfs(node):
        if node is None:
            return [True, 0]
        
        left, right = dfs(root.left), dfs(root.right)
        balanced = left and right and abs(left[1] - right[1]) <= 1

        return [balanced, max(left[1], right[1])]