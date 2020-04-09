65. Median of two Sorted Arrays
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

Example
Example 1

Input:
A = [1,2,3,4,5,6]
B = [2,3,4,5]
Output: 3.5
Example 2

Input:
A = [1,2,3]
B = [4,5]
Output: 3
Challenge
The overall run time complexity should be O(log (m+n)).

Clarification
The definition of the median:

The median here is equivalent to the median in the mathematical definition.

The median is the middle of the sorted array.

If there are n numbers in the array and n is an odd number, the median is A[(n-1)/2].

If there are n numbers in the array and n is even, the median is (A[n / 2] + A[n / 2 + 1]) / 2.

For example, the median of the array A=[1,2,3] is 2, and the median of the array A=[1,19] is 10.


//O(logk) = O(log(m + n))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return (double)search(nums1, 0, nums2, 0, len/2+1);
        }
        else {
            return ((double)search(nums1, 0, nums2, 0, len/2) + (double)search(nums1, 0, nums2, 0, len/2+1)) / 2.0;
        }
    }
    
    private int search(int[] nums1, int index1, int[] nums2, int index2, int k) {
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        
        int mid1 = index1 + k/2;
        int mid2 = index2 + k/2;
        if (mid1 >= nums1.length) {
            mid1 = nums1.length;
        }
        if (mid2 >= nums2.length) {
            mid2 = nums2.length;
        }
        
        if (nums1[mid1-1] <= nums2[mid2-1]) {
            return search(nums1, mid1, nums2, index2, k-mid1+index1);
        }
        else {
            return search(nums1, index1, nums2, mid2, k-mid2+index2);
        }
    }
}

//O(log(range)*(logm + logn))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        
        double ans2 = (double)search(nums1, nums2, len/2+1);
        //System.out.print(ans2+" ");
        if (len % 2 == 0) {
            double ans1 = (double)search(nums1, nums2, len/2);
            //System.out.println(ans1);
            return (ans1 + ans2) / 2.0;
        }
        else {
            return ans2;
        }
    }
    
    private int search(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k-1];
        }
        if (nums2.length == 0) {
            return nums1[k-1];
        }
        
        int start = Math.min(nums1[0], nums2[0]);
        int end = Math.max(nums1[nums1.length-1], nums2[nums2.length-1]);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(nums1, mid) + count(nums2, mid) < k) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        if (count(nums1, start) + count(nums2, start) < k) {
            return end;
        }
        return start;
    }
    
    private int count(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= k) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        if (nums[start] > k) {
            return start;
        }
        if (nums[end] <= k) {
            return end+1;
        }
        return end;
    }
}

//non recursion. O(logn).
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int len = nums1.length + nums2.length;
        int start = 0;
        int end = nums1.length;
        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = len/2 - mid1;
            
            int a1 = mid1 > 0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int a2 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
            int b1 = mid2 > 0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int b2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
            
            if (a2 >= b1 && b2 >= a1) {
                if (len % 2 == 1) {
                    return (double)Math.min(a2, b2);
                }
                else {
                    return ((double)Math.max(a1, b1) + (double)Math.min(a2, b2)) / 2.0;
                }
            }
            else if (a2 >= b1) {
                end = mid1-1;
            }
            else if (b2 >= a1) {
                start = mid1+1;
            }
        }
        
        return 0;
    }
}