from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [[1,0], [-1, 0], [0, 1], [0, -1]]
        ROWS, COLS = len(grid), len(grid[0])

        visited = set()
        queue = deque()

        result = 0

        if not grid:
            return result

        def bfs(r, c):
            queue.append((r,c))
            visited.add((r,c))

            while queue:
                row, col = queue.popleft()

                for direction_x, direction_y in directions:
                    new_row, new_col = row + direction_x, col + direction_y

                    if (new_row < 0 or new_row >= ROWS or new_col < 0 or new_col >= COLS or grid[new_row][new_col] == "0"):
                        continue
                    
                    queue.append((new_row, new_col))
                    grid[new_row][new_col] = "0"
        

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == "1":
                    bfs(r,c)
                    result += 1
        return result

