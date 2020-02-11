38. Search a 2D Matrix II
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Example
Example 1:

Input:
	[[3,4]]
	target=3
Output:1
Example 2:

Input:
    [
      [1, 3, 5, 7],
      [2, 4, 7, 8],
      [3, 5, 9, 10]
    ]
    target = 3
Output:2
Challenge
O(m+n) time and O(1) extra space


public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int ans=0;
        if(matrix.length==0 || matrix[0].length==0){
            return ans;
        }
        
        int x=matrix[0].length-1;
        int y=0;
        while(x>=0 && y<matrix.length){
            if(matrix[y][x]>target){
                x--;
            }
            else if(matrix[y][x]==target){
                ans++;
                y++;
                x--;
            }
            else{
                y++;
            }
        }
        return ans;
    }
}