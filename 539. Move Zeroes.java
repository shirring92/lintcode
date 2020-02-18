539. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example
Example 1:

Input: nums = [0, 1, 0, 3, 12],
Output: [1, 3, 12, 0, 0].
Example 2:

Input: nums = [0, 0, 0, 3, 1],
Output: [3, 1, 0, 0, 0].
Notice
You must do this in-place without making a copy of the array.
Minimize the total number of operations.


public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, index);
                index++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}