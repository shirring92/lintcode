587. Two Sum - Unique pairs
Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

Example
Example 1:

Input: nums = [1,1,2,45,46,46], target = 47 
Output: 2
Explanation:

1 + 46 = 47
2 + 45 = 47

Example 2:

Input: nums = [1,1], target = 2 
Output: 1
Explanation:
1 + 1 = 2

//O(nlogn)
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int ans = 0;
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            
            
            if (nums[left] + nums[right] == target) {
                ans++;
                left++;
                right--;
            }
            else if (nums[left] + nums[right] < target) {
                left++;
            }
            else {
                right--;
            }
            
            while (left>0 && left<right && nums[left] == nums[left-1]) {
                left++;
            }
            while (right<nums.length-1 && left<right && nums[right] == nums[right+1]) {
                right--;
            }
        }
        return ans;
    }
}