192. Wildcard Matching
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example
Example 1

Input:
"aa"
"a"
Output: false
Example 2

Input:
"aa"
"aa"
Output: true
Example 3

Input:
"aaa"
"aa"
Output: false
Example 4

Input:
"aa"
"*"
Output: true
Explanation: '*' can replace any string
Example 5

Input:
"aa"
"a*"
Output: true
Example 6

Input:
"ab"
"?*"
Output: true
Explanation: '?' -> 'a' '*' -> 'b'
Example 7

Input:
"aab"
"c*a*b"
Output: false


//memorize DFS. O(m*n). O(m*n)
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    boolean[][] visited;
    boolean[][] memo;
    public boolean isMatch(String s, String p) {
        // write your code here
        visited = new boolean[s.length()][p.length()];
        memo = new boolean[s.length()][p.length()];
        return helper(s, 0, p, 0);
        
    }
    
    private boolean helper(String s, int i, String p, int j) {
        //System.out.println(s.length());
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            for (int k=j; k<p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        
        if (visited[i][j]) {
            return memo[i][j];
        }
        
        visited[i][j] = true;
        
        if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && helper(s, i+1, p, j+1)) {
            memo[i][j] = true;
            return true;
        }
        else if (p.charAt(j) == '*') {
            if(helper(s, i+1, p, j) || helper(s, i, p, j+1)) {
                memo[i][j] = true;
                return true;
            }
        }
        
        return false;
    }
}

//DP
