120. Word Ladder
Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, output the length of the sequence.
Transformation rule such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary. (Start and end words do not need to appear in the dictionary )
Example
Example 1:

Input：start = "a"，end = "c"，dict =["a","b","c"]
Output：2
Explanation：
"a"->"c"
Example 2:

Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
Output：5
Explanation：
"hit"->"hot"->"dot"->"dog"->"cog"
Notice
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.


// Bidirectional BFS
public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        Queue<String> q = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        
        q.offer(start);
        q2.offer(end);
        set.add(start);
        set2.add(end);
        int cnt = 1;
        int cnt2 = 1;
        while (cnt <= dict.size() + 2 && !q.isEmpty() && !q2.isEmpty()) {
            int size = q.size();
            for (int k=0; k<size; k++) {
                String str = q.poll();
                for (int i=0; i<str.length(); i++) {
                    for (char c='a'; c<='z'; c++) {
                        if (c == str.charAt(i)) {
                            continue;
                        }
                        String s = str.substring(0, i) + c + str.substring(i+1);
                        if (set2.contains(s)) {
                            return cnt + cnt2;
                        }
                        if (dict.contains(s) && !set.contains(s)) {
                            q.offer(s);
                            set.add(s);
                        }
                    }
                }
            }
            cnt++;
            
            int size2 = q2.size();
            for (int i=0; i<size2; i++) {
                String str = q2.poll();
                for (int j=0; j<str.length(); j++) {
                    for (char c='a'; c<='z'; c++) {
                        if (c == str.charAt(j)) {
                            continue;
                        }
                        String s = str.substring(0, j) + c + str.substring(j+1);
                        if (set.contains(s)) {
                            return cnt + cnt2;
                        }
                        if (dict.contains(s) && !set2.contains(s)) {
                            q2.offer(s);
                            set2.add(s);
                        }
                    }
                }
            }
            cnt2++;
        }
        
        return 0;
    }
}