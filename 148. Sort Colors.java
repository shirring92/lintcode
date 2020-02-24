148. Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example
Example 1

Input : [1, 0, 1, 2]
Output : [0, 1, 1, 2]
Explanation : sort it in-place
Challenge
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Notice
You are not suppose to use the library's sort function for this problem.
You should do it in-place (sort numbers in the original array).

public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int red = 0;
        int blue = nums.length - 1;
        int index = 0;
        while (index <= blue) {
            if (nums[index] == 2) {
                swap(nums, blue, index);
                blue--;
            }
            if (nums[index] == 0) {
                swap(nums, red, index);
                red++;
                index++;
            }
            if (nums[index] == 1) {
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