154. Regular Expression Matching
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).


The function prototype should be:

bool isMatch(string s, string p)

isMatch("aa","a") → false

isMatch("aa","aa") → true

isMatch("aaa","aa") → false

isMatch("aa", "a*") → true

isMatch("aa", ".*") → true

isMatch("ab", ".*") → true

isMatch("aab", "c*a*b") → true

Example
Example 1:

Input："aa"，"a"
Output：false
Explanation：
unable to match
Example 2:

Input："aa"，"a*"
Output：true
Explanation：
'*' can repeat a


//DFS+memoize
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        return helper(s, 0, p, 0, visited, memo);
    }
    
    private boolean helper(String s, int i, String p, int j, boolean[][] visited, boolean[][] memo) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            for (int k=j; k<p.length(); k++) {
                if (p.charAt(k) != '*' ) {
                    if (k == p.length() - 1 || p.charAt(k+1) != '*') {
                        return false;
                    }
                }
            }
            return true;
        }
        
        if (visited[i][j]) {
            return memo[i][j];
        }
        
        boolean ans = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            ans = helper(s, i, p, j+2, visited, memo) || (equal(s, i, p, j) && helper(s, i+1, p, j, visited, memo));
        }
        else {
            ans = equal(s, i, p, j) && helper(s, i+1, p, j+1, visited, memo);
        }
        
        visited[i][j] = true;
        memo[i][j] = ans;
        
        return ans;
    }
    
    private boolean equal(String s, int i, String p, int j) {
        if (s.charAt(i) == p.charAt(j) ||  p.charAt(j) == '.') {
            return true;
        }
        else {
            return false;
        }
    }
}