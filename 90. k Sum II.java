90. k Sum II
Given n unique postive integers, number k (1<=k<=n) and target.

Find all possible k integers where their sum is target.

Example
Example 1:

Input: [1,2,3,4], k = 2, target = 5
Output:  [[1,4],[2,3]]
Example 2:

Input: [1,3,4,6], k = 3, target = 8
Output:  [[1,3,4]]	

//recursion. O(2^n)
public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return ans;
        }
        
        Arrays.sort(A);
        helper(A, k, target, 0, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    private void helper(int[] A, int k, int target, int index, List<Integer> list, List<List<Integer>> ans) {
        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        for (int i=index; i<A.length; i++) {
            if (target < A[i]) {
                return;
            }
            
            list.add(A[i]);
            helper(A, k-1, target - A[i], i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}