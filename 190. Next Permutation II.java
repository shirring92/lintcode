190. Next Permutation II
中文English
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

Example
Example 1:

Input:1,2,3
Output:1,3,2
Example 2:

Input:3,2,1
Output:1,2,3
Example 3:

Input:1,1,5
Output:1,5,1
Challenge
The replacement must be in-place, do not allocate extra memory.

//recursion
public class Solution {
    /**
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums.length <= 1) {
            return;
        }
        
        int index = -1;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        for (int i=nums.length-1; i>index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                reverse(nums, index+1, nums.length-1);
                break;
            }
        }
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}