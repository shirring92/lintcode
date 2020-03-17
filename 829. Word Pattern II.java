829. Word Pattern II
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab", str = "ss", return false.)

Example
Example 1

Input:
pattern = "abab"
str = "redblueredblue"
Output: true
Explanation: "a"->"red","b"->"blue"
Example 2

Input:
pattern = "aaaa"
str = "asdasdasdasd"
Output: true
Explanation: "a"->"asd"
Example 3

Input:
pattern = "aabb"
str = "xyzabcxzyabc"
Output: false
Notice
You may assume both pattern and str contains only lowercase letters.

//recursion
public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        HashMap<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        return helper(pattern, str, map, set);
    }
    
    private boolean helper(String pattern, String str, HashMap<Character, String> map, Set<String> set) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        if (str.length() == 0) {
            return false;
        }
        
        char c = pattern.charAt(0);
        if (map.containsKey(c)) {
            String substr = map.get(c);
            int len = substr.length();
            if (len <= str.length() && str.substring(0, len).equals(substr)) {
                return helper(pattern.substring(1), str.substring(substr.length()), map, set);
            }
            else {
                return false;
            }
        }
        
        for (int i=0; i<str.length(); i++) {
            String substr = str.substring(0, i+1);
            if (set.contains(substr)) {
                continue;
            }
            set.add(substr);
            map.put(c, substr);
            if (helper(pattern.substring(1), str.substring(i+1), map, set)) {
                return true;
            };
            map.remove(c);
            set.remove(substr);
        }
        
        return false;
    }
}