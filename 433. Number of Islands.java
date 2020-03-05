433. Number of Islands
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Example 1:

Input:
[
  [1,1,0,0,0],
  [0,1,0,0,1],
  [0,0,0,1,1],
  [0,0,0,0,0],
  [0,0,0,0,1]
]
Output:
3
Example 2:

Input:
[
  [1,1]
]
Output:
1

// BFS
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        int[] nextx = new int[]{0, 0, 1, -1};
        int[] nexty = new int[]{1, -1, 0, 0};
        int cnt = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]) {
                    q.offer(new int[]{i,j});
                    grid[i][j] = false;
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        for (int k=0; k<4; k++) {
                            int x = nextx[k] + point[0];
                            int y = nexty[k] + point[1];
                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y]) {
                                q.offer(new int[]{x, y});
                                grid[x][y] = false;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}