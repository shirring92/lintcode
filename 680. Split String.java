680. Split String
Give a string, you can choose to split the string after one character or two adjacent characters, and make the string to be composed of only one character or two characters. Output all possible results.

Example
Example1

Input: "123"
Output: [["1","2","3"],["12","3"],["1","23"]]
Example2

Input: "12345"
Output: [["1","23","45"],["12","3","45"],["12","34","5"],["1","2","3","45"],["1","2","34","5"],["1","23","4","5"],["12","3","4","5"],["1","2","3","4","5"]]

//recursion
public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (s == null) {
            return ans;
        }
        
        helper(s, 0, new ArrayList<String>(), ans);
        
        return ans;
    }
    
    private void helper(String s, int index, List<String> list, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(s.substring(index, index+1));
        helper(s, index+1, list, ans);
        list.remove(list.size()-1);
        if (index < s.length() - 1) {
            list.add(s.substring(index, index+2));
            helper(s, index+2, list, ans);
            list.remove(list.size()-1);
        }
        
    }
}
