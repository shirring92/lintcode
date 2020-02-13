604. Window Sum
Given an array of n integers, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

Example
Example 1

Input：array = [1,2,7,8,5], k = 3
Output：[10,17,20]
Explanation：
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums==null || nums.length==0){
            return new int[0];
        }
        
        int[] ans=new int[nums.length-k+1];
        ans[0]=0;
        for(int i=0;i<k;i++){
            ans[0]+=nums[i];
        }
        for(int i=1;i<nums.length-k+1;i++){
            ans[i]=ans[i-1]-nums[i-1]+nums[i+k-1];
        }
        return ans;
    }
}