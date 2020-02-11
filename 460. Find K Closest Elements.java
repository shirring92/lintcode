460. Find K Closest Elements
Given target, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Example
Example 1:

Input: A = [1, 2, 3], target = 2, k = 3
Output: [2, 1, 3]
Example 2:

Input: A = [1, 4, 6, 8], target = 3, k = 3
Output: [4, 1, 6]
Challenge
O(logn + k) time

Notice
The value k is a non-negative integer and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 10^410
​4
​​ 
Absolute value of elements in the array will not exceed 10^410
​4
​​

public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] ans=new int[k];
        if(A==null || A.length==0 || A.length<k){
            return ans;
        }
        
        //O(logn): find closest element to target in A
        int start=0;
        int end=A.length-1;
        int mid=end/2;
        while(start+1<end){
            if(A[mid]<target){
                start=mid;
            }
            else if(A[mid]>target){
                end=mid;
            }
            else{
                break;
            }
            mid=start+(end-start)/2;
        }
        if(A[end]==target){
            mid=start;
        }
        
        //O(k): start from mid, find k closest element
        int left=mid;
        int right=mid+1;
        for(int i=0;i<k;i++){
            if(left>=0 && right<A.length && target-A[left]<=A[right]-target){
                ans[i]=A[left];
                left--;
            }
            else if(left>=0 && right<A.length && target-A[left]>A[right]-target){
                ans[i]=A[right];
                right++;
            }
            else if(left<0){
                ans[i]=A[right];
                right++;
            }
            else if(right>=A.length){
                ans[i]=A[left];
                left--;
            }
        }
        return ans;
    }
}