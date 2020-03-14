152. Combinations
Given two integers n and k. Return all possible combinations of k numbers out of 1, 2, ... , n.

Example
Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Example 2:

Input: n = 4, k = 1
Output: [[1],[2],[3],[4]]
Notice
You can return all combinations in any order, but numbers in a combination should be in ascending order.

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        
        helper(n, k, 1, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    private void helper(int n, int k, int index, List<Integer> list, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=index; i<=n; i++) {
            list.add(i);
            helper(n, k-1, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}