127. Topological Sorting
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

Example
For graph as follow:

图片

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
Challenge
Can you do it in both BFS and DFS?

Clarification
Learn more about representation of graphs

Notice
You can assume that there is at least one topological order in the graph.

//BFS
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        if (graph == null) {
            return ans;
        }
        
        //calculate in degree
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode nei: node.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, 1);
                }
                else {
                    map.put(nei, map.get(nei) + 1);
                }
            }
        }
        
        //push node in queue, get node with in degree is 0
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node: graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                ans.add(node);
            }
        }
        
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode nei: node.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    q.offer(nei);
                    ans.add(nei);
                    map.remove(nei);
                }
            }
        }
        
        return ans;
    }
}


//DFS
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return graph;
        }
        
        Set<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode nei: node.neighbors) {
                if (!set.contains(nei)) {
                    set.add(nei);
                }
            }
        }
        
        
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        Set<DirectedGraphNode> set2 = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node: graph) {
            if (!set.contains(node)) {
                dfs(node, set2, stack);
            }
        }
        
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        
        return ans;
    }
    
    private void dfs(DirectedGraphNode node, Set<DirectedGraphNode> set, Stack<DirectedGraphNode> stack) {
        for (DirectedGraphNode nei: node.neighbors) {
            if (!set.contains(nei)) {
                dfs(nei, set, stack);
            }
        }
        
        stack.push(node);
        set.add(node);
    }
}