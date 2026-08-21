# Definition for a binary tree node.
# class TreeNode:
#     def __init__(Collection, self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        """ BFS """

        result = []

        q = collections.deque()

        q.append(root)

        while q:

            n = len(q)
            lst = []
            for i in range(n):
                node = q.popleft()

                if node:
                    lst.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
                
            if lst:
                result.append(lst)
        return result

            