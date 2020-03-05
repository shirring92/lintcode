778. Pacific Atlantic Water Flow
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Example
Example 1:

Input:
matrix = 
[[1,2,2,3,5],
[3,2,3,4,4],
[2,4,5,3,1],
[6,7,1,4,5],
[5,1,1,2,4]]
Output:
[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation:
Pacific ~ ~ ~ ~ ~
      ~ 1 2 2 3 5 *
      ~ 3 2 3 4 4 *
      ~ 2 4 5 3 1 *
      ~ 6 7 1 4 5 *
      ~ 5 1 1 2 4 *
        * * * * * Atlantic
Example 2:

Input:
matrix =
[[1,2],
[4,3]]
Output:
[[0,1],[1,0],[1,1]]
Notice
1.The order of returned grid coordinates does not matter.
2.Both m and n are less than 150.


//BFS
public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        
        boolean[][] pacific = pacific(matrix);
        boolean[][] atlantic = atlantic(matrix);
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                //System.out.println(i+" "+j+" "+pacific[i][j]+" "+atlantic[i][j]);
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
    
    private boolean[][] pacific(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean[][] ans = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> q = new LinkedList<int[]>();
        
        for (int i=0; i<matrix.length; i++) {
            ans[i][0] = true;
            visited[i][0] = true;
            q.offer(new int[]{i, 0});
        }
        
        for (int i=1; i<matrix[0].length; i++) {
            ans[0][i] = true;
            visited[0][i] = true;
            q.offer(new int[]{0, i});
        }
        
        int[][] grid = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] ptr = q.poll();
                for (int k=0; k<4; k++) {
                    int row = ptr[0] + grid[0][k];
                    int col = ptr[1] + grid[1][k];
                    if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && !visited[row][col] && matrix[row][col] >= matrix[ptr[0]][ptr[1]]) {
                        visited[row][col] = true;
                        ans[row][col] = true;
                        q.offer(new int[]{row, col});
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean[][] atlantic(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean[][] ans = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> q = new LinkedList<int[]>();
        
        for (int i=matrix.length-1; i>=0; i--) {
            ans[i][matrix[0].length-1] = true;
            visited[i][matrix[0].length-1] = true;
            q.offer(new int[]{i, matrix[0].length-1});
        }
        
        for (int i=matrix[0].length-2; i>=0; i--) {
            ans[matrix.length-1][i] = true;
            visited[matrix.length-1][i] = true;
            q.offer(new int[]{matrix.length-1, i});
        }
        
        int[][] grid = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] ptr = q.poll();
                for (int k=0; k<4; k++) {
                    int row = ptr[0] + grid[0][k];
                    int col = ptr[1] + grid[1][k];
                    if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && !visited[row][col] && matrix[row][col] >= matrix[ptr[0]][ptr[1]]) {
                        visited[row][col] = true;
                        ans[row][col] = true;
                        q.offer(new int[]{row, col});
                    }
                }
            }
        }
        
        return ans;
    }
}