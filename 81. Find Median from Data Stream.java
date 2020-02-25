81. Find Median from Data Stream
Numbers keep coming, return the median of numbers at every time a new number added.

Example
Example 1

Input: [1,2,3,4,5]
Output: [1,1,2,2,3]
Explanation:
The medium of [1] and [1,2] is 1.
The medium of [1,2,3] and [1,2,3,4] is 2.
The medium of [1,2,3,4,5] is 3.
Example 2

Input: [4,5,1,3,2,6,0]
Output: [4,4,4,3,3,3,3]
Explanation:
The medium of [4], [4,5], [4,5,1] is 4.
The medium of [4,5,1,3], [4,5,1,3,2], [4,5,1,3,2,6] and [4,5,1,3,2,6,0] is 3.
Challenge
Total run time in O(nlogn).

Clarification
What's the definition of Median?

The median is not equal to median in math.
Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]A[(n−1)/2].
For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

//O(nlogn), space O(n)
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        Queue<Integer> minh = new PriorityQueue<Integer>();
        Queue<Integer> maxh = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] ans = new int[nums.length];
        
        int med = nums[0];
        maxh.offer(med);
        ans[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > med) {
                minh.offer(nums[i]);
            }
            else {
                maxh.offer(nums[i]);
            }
            
            if (maxh.size() > minh.size() + 1) {
                minh.offer(maxh.poll());
            }
            else if (maxh.size() < minh.size()) {
                maxh.offer(minh.poll());
            }
            med = maxh.peek();
            ans[i] = med;
        }
        
        return ans;
    }
}