28. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example
Example 1:
	Input:  [[5]],2
	Output: false
	
	Explanation: 
	false if not included.
	
Example 2:
	Input:  [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
],3
	Output: true
	
	Explanation: 
	return true if included.
Challenge
O(log(n) + log(m)) time


public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        
        //find the row target is located. O(logm)
        int rowstart=0;
        int rowend=matrix.length-1;
        while(rowstart+1<rowend){
            int mid=rowstart+(rowend-rowstart)/2;
            if(matrix[mid][0]<target){
                rowstart=mid;
            }
            else if(matrix[mid][0]>target){
                rowend=mid;
            }
            else{//matrix[mid][0]==target
                return true;
            }
        }
        if(matrix[rowend][0]<target){
            rowstart=rowend;
        }
        else if(matrix[rowend][0]==target){
            return true;
        }
        
        //find target in the row. O(logn)
        int colstart=0;
        int colend=matrix[0].length-1;
        while(colstart+1<colend){
            int mid=colstart+(colend-colstart)/2;
            if(matrix[rowstart][mid]<target){
                colstart=mid;
            }
            else if(matrix[rowstart][mid]>target){
                colend=mid;
            }
            else{//matrix[rowstart][mid]==target
                return true;
            }
        }
        if(matrix[rowstart][colstart]==target || matrix[rowstart][colend]==target){
            return true;
        }
        return false;
    }
}