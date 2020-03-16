33. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other(Any two queens can't be in the same row, column, diagonal line).

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' each indicate a queen and an empty space respectively.

Example
Example 1:

Input:1
Output:
   [["Q"]]


Example 2:

Input:4
Output:
[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]

Challenge
Can you do it without recursion?


//
public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        
        helper(n, 0, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    private void helper(int n, int k, List<Integer> list, List<List<String>> ans) {
        if (k == n) {
            ans.add(build(list));
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (check(i, k, list)) {
                continue;
            }
            list.add(i);
            helper(n, k+1, list, ans);
            list.remove(list.size()-1);
        }
    }
    
    private boolean check(int col, int row, List<Integer> list) {
        for (int i=0; i<row; i++) {
            if (list.get(i) == col) {	//check column
                return true;
            }
			
            if (list.get(i) + i == col + row) {	//check diagonal line
                return true;
            }
            if (list.get(i) - i == col - row) {	//check diagonal line
                return true;
            }
        }
        return false;
    }
    
    private List<String> build(List<Integer> list) {
        List<String> ans = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            String str = "";
            for (int j=0; j<list.size(); j++) {
                if (list.get(i) == j) {
                    str += "Q";
                }
                else {
                    str += ".";
                }
            }
            ans.add(str);
        }
        
        return ans;
    }
}

//iteration. O(n^3). O(n^2)
public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        for (int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            stack.push(list);
        }
        
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            if (list.size() == n) {
                ans.add(build(list));
                continue;
            }
            for (int i=0; i<n; i++) {
                if (check(i, list)) {
                    continue;
                }
                list.add(i);
                stack.push(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
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
    
    private List<String> build(List<Integer> list) {
        List<String> ans = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            String str = "";
            for (int j=0; j<list.size(); j++) {
                if (j == list.get(i)) {
                    str += "Q";
                }
                else {
                    str += ".";
                }
            }
            ans.add(str);
        }
        
        return ans;
    }
}