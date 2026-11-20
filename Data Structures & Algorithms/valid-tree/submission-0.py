from collections import defaultdict

class Solution:
    def validTree(self, n: int, edges: list[list[int]]) -> bool:
        
        adj_map = defaultdict(list)
        path = set()

        if len(edges) > n - 1:
            return False
        
        for node, adjnode in edges:
            adj_map[node].append(adjnode)
            adj_map[adjnode].append(node)


        def dfs(curr_node, parent):

            if curr_node in path:
                return False

            path.add(curr_node)

            for neighbor in adj_map[curr_node]:
                if neighbor == parent:
                    continue

                if not dfs(neighbor, curr_node):
                    return False
            return True
        
        return dfs(0, -1) and len(path) == n