373. Partition Array by Odd and Even
Partition an integers array into odd number first and even number second.

Example
Example 1:

Input: [1,2,3,4]
Output: [1,3,2,4]
Example 2:

Input: [1,4,2,3,5,6]
Output: [1,3,5,4,2,6]
Challenge
Do it in-place.

Notice
The answer is not unique. All you have to do is give a vaild answer.

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int odd = 0;
        int even = nums.length - 1;
        while (odd <= even) {
            while (odd <= even && nums[odd]%2 == 1) {
                odd++;
            }
            while (odd <= even && nums[even]%2 == 0) {
                even--;
            }
            if (odd <= even) {
                swap(nums, odd, even);
                odd++;
                even--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}