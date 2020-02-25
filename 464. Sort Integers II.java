464. Sort Integers II
Given an integer array, sort it in ascending order in place. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.

Example
Example1:

Input: [3, 2, 1, 4, 5], 
Output: [1, 2, 3, 4, 5].
Example2:

Input: [2, 3, 1], 
Output: [1, 2, 3].


//quick sort
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        partition(A, 0, A.length-1);
    }
    
    private void partition(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = A[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }
        
        partition(A, start, left-1);
        partition(A, left, end);
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

//merge sort: O(nlogn), extra O(n) space
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        int[] B = divide(A, 0, A.length-1);
        for (int i=0; i<A.length; i++) {
            A[i] = B[i];
        }
    }
    
    private int[] divide(int[] A, int start, int end) {
        if (start == end) {
            return new int[]{A[start]};
        }
        
        int mid = start + (end - start) / 2;
        int[] l1 = divide(A, start, mid);
        int[] l2 = divide(A, mid+1, end);
        int[] ans = merge(l1, l2);
        
        return ans;
    }
    
    private int[] merge(int[] l1, int[] l2) {
        int[] ans = new int[l1.length + l2.length];
        
        int p1 = 0, p2 = 0;
        for (int i=0; i<ans.length; i++) {
            if (p2 >= l2.length || (p1 < l1.length && l1[p1] <= l2[p2])) {
                ans[i] = l1[p1++];
            }
            else {
                ans[i] = l2[p2++];
            }
        }
        
        return ans;
    }
}

//heap sort O(nlogn)
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return;
        }
        
        for (int i=A.length/2; i>=0; i--) {
            buildheap(A, i, A.length-1);
        }
        
        int end = A.length-1;
        while (end > 0) {
            swap(A, 0, end--);
            buildheap(A, 0, end);
        }
    }
    
    private void buildheap(int[] A, int start, int end) {
        int parent = start;
        
        while (parent <= end) {
            int child1 = parent*2+1;
            int child2 = parent*2+2;
            int child = -1;
            
            if (child1 <= end && child2 <= end) {
                child = (A[child1] > A[child2])? child1: child2;
            }
            else if (child1 <= end) {
                child = child1;
            }
            else {
                return;
            }
            
            //System.out.println(parent+" "+child);
            if (A[parent] < A[child]) {
                swap(A, parent, child);
            }
            parent = child;
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}