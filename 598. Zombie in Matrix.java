598. Zombie in Matrix
Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.

Example
Example 1:

Input:
[[0,1,2,0,0],
 [1,0,0,2,1],
 [0,1,0,0,0]]
Output:
2
Example 2:

Input:
[[0,0,0],
 [0,0,0],
 [0,0,1]]
Output:
4

//BFS
public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int day = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] ptr = q.poll();
                for (int k=0; k<4; k++) {
                    int ptrx = ptr[0] + x[k];
                    int ptry = ptr[1] + y[k];
                    if (ptrx >= 0 && ptrx < grid.length && ptry >= 0 && ptry < grid[0].length && grid[ptrx][ptry] == 0) {
                        q.offer(new int[]{ptrx, ptry});
                        grid[ptrx][ptry] = 1;
                    }
                }
            }
            day++;
        }
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        
        return day - 1;
    }
}