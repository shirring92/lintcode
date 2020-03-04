573. Build Post Office II
Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.

Example
Example 1:

Input：[[0,1,0,0,0],[1,0,0,2,1],[0,1,0,0,0]]
Output：8
Explanation： Placing a post office at (1,1), the distance that post office to all the house sum is smallest.
Example 2:

Input：[[0,1,0],[1,0,1],[0,1,0]]
Output：4
Explanation： Placing a post office at (1,1), the distance that post office to all the house sum is smallest.
Notice
You cannot pass through wall and house, but can pass through empty.
You only build post office on an empty.

//BFS
public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[][] dist = new int[grid.length][grid[0].length];
        int[][] build = new int[grid.length][grid[0].length];
        int house = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    helper(grid, build, dist, visited, i, j);
                    house++;
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<build.length; i++) {
            for (int j=0; j<build[0].length; j++) {
                if (Math.abs(build[i][j]) == house) {
                    ans = Math.max(ans, dist[i][j]);
                }
            }
        }
        
        if (ans == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return -ans;
        }
    }
    
    private void helper(int[][] grid, int[][] build, int[][] dist, boolean[][] visited, int i, int j) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s=0; s<size; s++) {
                int[] ptr = q.poll();
                for (int k=0; k<4; k++) {
                    int ptri = ptr[0] + x[k];
                    int ptrj = ptr[1] + y[k];
                    
                    if (ptri >= 0 && ptri < grid.length && ptrj >= 0 && ptrj < grid[0].length && grid[ptri][ptrj] == 0 && !visited[ptri][ptrj]) {
                        q.offer(new int[]{ptri, ptrj});
                        visited[ptri][ptrj] = true;
                        build[ptri][ptrj]--;
                        dist[ptri][ptrj] = dist[ptri][ptrj]-level;
                    }
                }
            }
            level++;
        }
    }
}