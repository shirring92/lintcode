52. Next Permutation
Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

Example
Example 1:

Input:[1]
Output:[1]
Example 2:

Input:[1,3,2,3]
Output:[1,3,3,2]
Example 3:

Input:[4,3,2,1]
Output:[1,2,3,4]
Notice
The list may contains duplicate integers.

//iteration
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null) {
            return nums;
        }
        
        boolean flag = false;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                swap(nums, i);
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            swaparray(nums, 0, nums.length-1);
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int index) {
        int len = nums.length;
        for (int i=len-1; i>index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        
        swaparray(nums, index+1, len-1);
    }
    
    private void swaparray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}