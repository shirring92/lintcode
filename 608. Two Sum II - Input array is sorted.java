608. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

Example
Example 1:

Input: nums = [2, 7, 11, 15], target = 9 
Output: [1, 2]
Example 2:

Input: nums = [2,3], target = 5
Output: [1, 2]
Notice
You may assume that each input would have exactly one solution.

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] ans = new int[2];
        
        if (nums == null || nums.length == 0 || nums[0] > target) {
            return ans;
        }
        
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }
        }
        return ans;
    }
}