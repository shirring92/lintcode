34. N-Queens II
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Example
Example 1:

Input: n=1
Output: 1
Explanation:
1:
1
Example 2:

Input: n=4
Output: 2
Explanation:
1:
0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0
2:
0 1 0 0 
0 0 0 1
1 0 0 0
0 0 1 0

//recursion
public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        // write your code here
        return helper(n, new ArrayList<Integer>());
    }
    
    private int helper(int n, List<Integer> list) {
        if (list.size() == n) {
            return 1;
        }
        
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (check(i, list)) {
                continue;
            }
            
            list.add(i);
            ans += helper(n, list);
            list.remove(list.size()-1);
        }
        
        return ans;
    }
    
    private boolean check(int col, List<Integer> list) {
        for (int i=0; i<list.size(); i++) {
            int precol = list.get(i);
            if (col == precol) {
                return true;
            }
            if (col + list.size() == precol + i) {
                return true;
            }
            if (col - list.size() == precol - i) {
                return true;
            }
        }
        
        return false;
    }
}