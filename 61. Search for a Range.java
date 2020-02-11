61. Search for a Range
Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Example
Example 1:

Input:
[]
9
Output:
[-1,-1]

Example 2:

Input:
[5, 7, 7, 8, 8, 10]
8
Output:
[3, 4]
Challenge
O(log n) time.

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] ans=new int[2];
        if(A==null || A.length==0){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        
		//1st search, find the start when target shows
        int start=0;
        int end=A.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(A[mid]<target){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(A[start]==target){
            ans[0]=start;
        }
        else if(A[end]==target){
            ans[0]=end;
        }
        else{
            ans[0]=-1;
        }
        
		//snd search, find the end when target shows
        start=0;
        end=A.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(A[mid]<=target){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(A[end]==target){
            ans[1]=end;
        }
        else if(A[start]==target){
            ans[1]=start;
        }
        else{
            ans[1]=-1;
        }
        return ans;
    }
}