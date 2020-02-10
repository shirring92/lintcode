457. Classical Binary Search
Find any position of a target number in a sorted array. Return -1 if target does not exist.

Example
Example 1:

Input: nums = [1,2,2,4,5,5], target = 2
Output: 1 or 2
Example 2:

Input: nums = [1,2,2,4,5,5], target = 6
Output: -1
Challenge
O(logn) time


public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums==null || nums.length==0){
            return -1;
        }

        int start=0;
        int end=nums.length-1;
        int mid=start+(end-start)/2;
        while(start+1<end){//important!! start<end will have deadlock(when start=end-1, will loop forever)
            if(nums[mid]<target){
                start=mid;
            }
            else if(nums[mid]>target){
                end=mid;
            }
            else{//nums[mid]==target
                return mid;
            }
            mid=start+(end-start)/2;
        }
        if(nums[start]==target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        return -1;
    }
}