75. Find Peak Element
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peak if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

Example
Example 1:
	Input:  [1, 2, 1, 3, 4, 5, 7, 6]
	Output:  1 or 6
	
	Explanation:
	return the index of peek.


Example 2:
	Input: [1,2,3,4,1]
	Output:  3

Challenge
Time complexity O(logN)

Notice
It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.

public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start=0;
        int end=A.length-1;
        while(start+2<end){//array has at least 3 numbers in it
            int mid=start+(end-start)/2;
            if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return mid;
            }
            if(A[mid]>A[mid+1]){
                end=mid;
            }
            else{
                start=mid;
            }
        }
        return start+(end-start)/2;
    }
}