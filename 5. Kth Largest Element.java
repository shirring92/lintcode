5. Kth Largest Element
Find K-th largest element in an array.

Example
Example 1:

Input:
n = 1, nums = [1,3,4,2]
Output:
4
Example 2:

Input:
n = 3, nums = [9,3,2,4,8]
Output:
4
Challenge
O(n) time, O(1) extra memory.

Notice
You can swap elements in the array


//partition
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < n) {
            return -1;
        }
        
        return partition(nums, 0, nums.length-1, n-1);
    }
    
    private int partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[k];
        }
        
        int left = start;
        int right = end;
        int pivot = nums[start+(end-start)/2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (left > k) {
            return partition(nums, start, left-1, k);
        }
        else {
            return partition(nums, left, end, k);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//quick select
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < n) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left-1;
            for (int i=left; i<right; i++) {
                if (nums[i] <= nums[right]) {
                    continue;
                }
                swap(nums, ++index, i);
            }
            swap(nums, ++index, right);
            if (index == n-1) {
                return nums[index];
            }
            else if (index > n-1) {
                right = index - 1;
            }
            else {
                left = index;
            }
        }
        
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//priorityqueue O(nlogk)
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < n) {
            return -1;
        }
        
        Queue<Integer> q = new PriorityQueue<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (q.size() < n) {
                q.offer(nums[i]);
            }
            else {
                q.offer(nums[i]);
                q.poll();
            }
        }
        
        return q.poll();
    }
}