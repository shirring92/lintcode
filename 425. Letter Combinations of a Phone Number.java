425. Letter Combinations of a Phone Number
Given a digit string excluded '0' and '1', return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

1	2
ABC	3
DEF
4
GHI	5
JKL	6
MNO
7
PQRS	8
TUV	9
WXYZ
Example
Example 1:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Explanation: 
'2' could be 'a', 'b' or 'c'
'3' could be 'd', 'e' or 'f'
Example 2:

Input: "5"
Output: ["j", "k", "l"]
Notice
Although the answer above is in lexicographical order, your answer could be in any order you want.

//recursion
public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        
        HashMap<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
        build(map);
        helper(digits, 0, "", ans, map);
        
        return ans;
    }
    
    private void helper(String digits, int index, String str, List<String> ans, HashMap<Integer, List<Character>> map) {
        if (index == digits.length()) {
            ans.add(str);
            return;
        }
        
        int num = digits.charAt(index) - '0';
        for (char c: map.get(num)) {
            helper(digits, index+1, str+c, ans, map);
        }
    }
    
    private void build(HashMap<Integer, List<Character>> map) {
        for (int i=2; i<=9; i++) {
            map.put(i, new ArrayList<Character>());
        }
        
        char c = 'a';
        for (int i=2; i<=6; i++) {
            for (int j=0; j<3; j++) {
                map.get(i).add(c);
                c++;
            }
        }
        
        for (int j=0; j<4; j++) {
            map.get(7).add(c);
            c++;
        }
        
        for (int j=0; j<3; j++) {
            map.get(8).add(c);
            c++;
        }
        
        for (int j=0; j<4; j++) {
            map.get(9).add(c);
            c++;
        }
    }
}