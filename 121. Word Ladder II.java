121. Word Ladder II
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, output sequence in dictionary order.
Transformation rule such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Example
Example 1:

Input：start = "a"，end = "c"，dict =["a","b","c"]
Output：[["a","c"]]
Explanation：
"a"->"c"
Example 2:

Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
Output：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation：
1."hit"->"hot"->"dot"->"dog"->"cog"
2."hit"->"hot"->"lot"->"log"->"cog"
The dictionary order of the first sequence is less than that of the second.
Notice
All words have the same length.
All words contain only lowercase alphabetic characters.
At least one solution exists.

//BFS+DFS
public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        dict.add(start);
        bfs(start, end, dict, map);
        
        list.add(start);
        dfs(start, end, map, list, ans);
        
        return ans;
    }
    
    private void bfs(String start, String end, Set<String> dict, HashMap<String, List<String>> map) {
        Set<String> setall = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.offer(end);
        
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> set = new HashSet<String>();
            for (int i=0; i<size; i++) {
                String str = q.poll();
                for (int j=0; j<str.length(); j++) {
                    for (char c='a'; c<='z'; c++) {
                        String sub = str.substring(0, j) + c + str.substring(j+1);
                        if (!dict.contains(sub)) {
                            continue;
                        }
                        if (setall.contains(sub)) {
                            continue;
                        }
                        if (!map.containsKey(sub)) {
                            map.put(sub, new ArrayList<String>());
                        }
                        map.get(sub).add(str);
                        if (!set.contains(sub)) {
                            q.offer(sub);
                            set.add(sub);
                        }
                    }
                }
            }
            setall.addAll(set);
            if (setall.contains(start)) {
                break;
            }
        }
    }
    
    private void dfs(String start, String end, HashMap<String, List<String>> map, List<String> list, List<List<String>> ans) {
        if (start == end) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (String str: map.get(start)) {
            list.add(str);
            dfs(str, end, map, list, ans);
            list.remove(list.size()-1);
        }
    }
}