178. Graph Valid Tree
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example
Example 1:

Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.
Example 2:

Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.
Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


//BFS
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges.length >= n) {
            return false;
        }
        
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i=0; i<n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei: map.get(node)) {
                q.offer(nei);
                map.get(nei).remove(node);
            }
            cnt++;
        }
        
        return cnt == n;
    }
}


//DFS
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges.length >= n) {
            return false;
        }
        
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i=0; i<n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> set = new HashSet<Integer>();
        if (!dfs(0, map, set)) {
            return false;
        }
        else {
            return set.size() == n;
        }
    }
    
    private boolean dfs(int root, HashMap<Integer, Set<Integer>> map, Set<Integer> set) {
        if (set.contains(root)) {
            return false;
        }

        set.add(root);
        for (int nei: map.get(root)) {
            map.get(nei).remove(root);
            if(!dfs(nei, map, set)) {
                return false;
            }
        }
        
        return true;
    }
}