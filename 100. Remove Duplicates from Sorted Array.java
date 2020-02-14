100. Remove Duplicates from Sorted Array
Given a sorted array, 'remove' the duplicates in place such that each element appear only once and return the 'new' length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Example
Example 1:

Input:  []
Output: 0
Example 2:

Input:  [1,1,2]
Output: 2	
Explanation:  uniqued array: [1,2]

public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int index=0;
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            nums[index++] = nums[i];
        }
        
        return index;
    }
}