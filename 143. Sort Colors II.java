143. Sort Colors II
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Example
Example1

Input: 
[3,2,2,1,4] 
4
Output: 
[1,2,2,3,4]
Example2

Input: 
[2,1,1,2,2] 
2
Output: 
[1,1,2,2,2]
Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?

Notice
You are not suppose to use the library's sort function for this problem.
k <= n


//quick sort, O(nlogn)
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        
        partition(colors, 0, colors.length-1);
    }
    
    private void partition(int[] colors, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = colors[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && colors[left] < pivot) {
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(colors, left, right);
                left++;
                right--;
            }
        }
        
        partition(colors, start, left-1);
        partition(colors, left, end);
    }
    
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}

//rainbow sort: O(nlogk)
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        
        partition(colors, 0, colors.length-1, 1, k);
    }
    
    private void partition(int[] colors, int start, int end, int from, int to) {
        if (start >= end) {
            return;
        }
        
        if (from >= to) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = from + (to - from) / 2;
        while (left <= right) {
            while (left <= right && colors[left] <= pivot) {
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(colors, left, right);
                left++;
                right--;
            }
        }
        
        partition(colors, start, left-1, from, pivot);
        partition(colors, left, end, pivot+1, to);
    }
    
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}