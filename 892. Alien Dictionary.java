892. Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example
Example 1:

Input：["wrt","wrf","er","ett","rftt"]
Output："wertf"
Explanation：
from "wrt"and"wrf" ,we can get 't'<'f'
from "wrt"and"er" ,we can get 'w'<'e'
from "er"and"ett" ,we can get 'r'<'t'
from "ett"and"rftt" ,we can get 'e'<'r'
So return "wertf"

Example 2:

Input：["z","x"]
Output："zx"
Explanation：
from "z" and "x"，we can get 'z' < 'x'
So return "zx"
Notice
You may assume all letters are in lowercase.
The dictionary is invalid, if a is prefix of b and b is appear before a.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return the smallest in normal lexicographical order


public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        if (words == null || words.length == 0) {
            return new String();
        }
        
        HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        int[] degree = new int[26];
        buildgraph(words, map, degree);
        
        Queue<Character> q = new PriorityQueue<Character>();
        String ans = toposort(map, degree, q);
        
        if (ans.length() == map.size()) {
            return ans;
        }
        else {
            return "";
        }
    }
    
    private void buildgraph(String[] words, HashMap<Character, List<Character>> map, int[] degree) {
        for (String s: words) {
            for (int i=0; i<s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), new ArrayList<Character>());
                } 
            }
        }
        
        for (int i=1; i<words.length; i++) {
            String w1 = words[i-1];
            String w2 = words[i];
            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    degree[w2.charAt(j) - 'a']++;
                    break;
                }
            }
        }
    }
    
    private String toposort(HashMap<Character, List<Character>> map, int[] degree, Queue<Character> q) {
        for (char c: map.keySet()) {
            if (degree[c - 'a'] == 0) {
                q.offer(c);
            }
        }
        
        String ans = "";
        while (!q.isEmpty()) {
            char c = q.poll();
            ans += c;
            for (char nei: map.get(c)) {
                degree[nei - 'a']--;
                if (degree[nei - 'a'] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        return ans;
    }
}