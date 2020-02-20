59. 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Example
Example 1:

Input:[2,7,11,15],3
Output:20
Explanation:
2+7+11=20
Example 2:

Input:[-1,2,1,-4],1
Output:2
Explanation:
-1+2+1=2
Challenge
O(n^2) time, O(1) extra space

Notice
You may assume that each input would have exactly one solution.

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers.length < 3) {
            return -1;
        }
        
        Arrays.sort(numbers);
        
        int diff = 0;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<numbers.length-2; i++) {
            int temp = target - numbers[i];
            int left = i+1;
            int right = numbers.length-1;
            while (left < right) {
                diff = temp - numbers[left] - numbers[right];
                if (numbers[left] + numbers[right] < temp) {
                    left++;
                }
                else if (numbers[left] + numbers[right] > temp) {
                    right--;
                }
                else {
                    return target;
                }
                if (Math.abs(diff) < Math.abs(ans)) {
                    ans = diff;
                }
            }
        }
        
        return target - ans;
    }
}