from collections import deque

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        ROWS, COLS = len(heights), len(heights[0])
        pac = [[False] * COLS for _ in range(ROWS)]
        atl = [[False] * COLS for _ in range(ROWS)]

        def bfs(source, ocean):
            queue = deque(source)

            while queue:
                row, col = queue.popleft()
                ocean[row][col] = True

                for direction_x, direction_y in directions:
                    new_row, new_col = row + direction_x, col + direction_y

                    if (0 <= new_row < ROWS and 0 <= new_col < COLS and not ocean[new_row][new_col] and heights[new_row][new_col] >= heights[row][col]):
                        queue.append((new_row, new_col))


        pacific = []
        atlantic = []

        for c in range(COLS):
            pacific.append((0,c))
            atlantic.append((ROWS - 1, c))
        
        for r in range(ROWS):
            pacific.append((r, 0))
            atlantic.append((r, COLS - 1))

        result = []

        bfs(pacific, pac)
        bfs(atlantic, atl)

        for r in range(ROWS):
            for c in range(COLS):
                if pac[r][c] and atl[r][c]:
                    result.append([r,c])
        
        return result
        

        
