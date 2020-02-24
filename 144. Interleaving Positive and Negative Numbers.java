144. Interleaving Positive and Negative Numbers
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

Example
Example 1

Input : [-1, -2, -3, 4, 5, 6]
Outout : [-1, 5, -2, 4, -3, 6]
Explanation :  any other reasonable answer.
Challenge
Do it in-place and without extra memory.

Notice
You are not necessary to keep the original order of positive integers or negative integers.

public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return;
        }
        
        int index = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] < 0) {
                swap(A, index, i);
                index++;
            }
        }
        
        int left = 0;
        int right = A.length - 1;
        
        if (A.length % 2 == 1) {
            if (A[A.length/2] > 0) {//pos first
                right--;
            }
            else {//neg first
                left++;
            }
        }
        while (left <= right) {
            if (left <= right) {
                swap(A, left, right);
                left = left + 2;
                right = right - 2;
            }
        }
    }
    
    private void swap(int[] A, int i, int j){
        int tmp=A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
}