582. Word Break II
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

Example
Example 1:

Input："lintcode"，["de","ding","co","code","lint"]
Output：["lint code", "lint co de"]
Explanation：
insert a space is "lint code"，insert two spaces is "lint co de".
Example 2:

Input："a"，[]
Output：[]
Explanation：dict is null.


//DFS+memoize
public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        if (wordDict.isEmpty()) {
            return new ArrayList<>();
        }
        
        HashMap<String, List<String>> memo = new HashMap<String, List<String>>();
        return helper(s, wordDict, memo);
    }
    
    private List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> memo) {
        List<String> ans = new ArrayList<String>();
        if (s.length() == 0) {
            return ans;
        }
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        if (wordDict.contains(s)) {
            ans.add(s);
        }
        
        for (int i=0; i<s.length(); i++) {
            String sub = s.substring(0, i+1);
            String str = s.substring(i+1);
            if (wordDict.contains(sub)) {
                List<String> sublist = helper(str, wordDict, memo);
                for (String substr: sublist) {
                    ans.add(sub+" "+substr);
                }
            }
        }
        
        //System.out.println(s+" "+ans.size());
        memo.put(s, ans);
        
        return ans;
    }
}