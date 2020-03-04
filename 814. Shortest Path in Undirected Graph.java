814. Shortest Path in Undirected Graph
Given an undirected graph in which each edge's length is 1, and two nodes from the graph. Return the length of the shortest path between two given nodes.

Example
Example 1:

Input: graph = {1,2,4#2,1,4#3,5#4,1,2#5,3}, node1 = 3, node2 = 5
Output: 1
Explanation:
  1------2  3
   \     |  | 
    \    |  |
     \   |  |
      \  |  |
        4   5
Example 2:

Input: graph = {1,2,3,4#2,1,3#3,1#4,1,5#5,4}, node1 = 1, node2 = 5
Output: 2
Clarification
About the representation of graph


//BFS
/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph: a list of Undirected graph node
     * @param A: nodeA
     * @param B: nodeB
     * @return:  the length of the shortest path
     */
    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        // Write your code here
        if (graph == null || graph.size() == 0) {
            return -1;
        }
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        q.offer(A);
        set.add(A);
        
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                UndirectedGraphNode node = q.poll();
                for (UndirectedGraphNode nei: node.neighbors) {
                    if (nei.label == B.label) {
                        return dist+1;
                    }
                    if (!set.contains(nei)) {
                        q.offer(nei);
                        set.add(nei);
                    }
                }
            }
            dist++;
        }
        
        return -1;
    }
}

//Bidirectional BFS
/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph: a list of Undirected graph node
     * @param A: nodeA
     * @param B: nodeB
     * @return:  the length of the shortest path
     */
    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        // Write your code here
        if (graph == null || graph.size() == 0) {
            return -1;
        }
        
        Queue<UndirectedGraphNode> q1 = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q2 = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set1 = new HashSet<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set2 = new HashSet<UndirectedGraphNode>();
        q1.offer(A);
        q2.offer(B);
        set1.add(A);
        set2.add(B);
        
        int dist1 = 0;
        int dist2 = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1= q1.size();
            for (int i=0; i<size1; i++) {
                UndirectedGraphNode node = q1.poll();
                for (UndirectedGraphNode nei: node.neighbors) {
                    if (set2.contains(nei)) {
                        return dist1 + dist2 + 1;
                    }
                    if (!set1.contains(nei)) {
                        q1.offer(nei);
                        set1.add(nei);
                    }
                }
            }
            dist1++;
            
            int size2 = q2.size();
            for (int i=0; i<size2; i++) {
                UndirectedGraphNode node = q2.poll();
                for (UndirectedGraphNode nei: node.neighbors) {
                    if (set1.contains(nei)) {
                        return dist1 + dist2 + 1;
                    }
                    if (!set2.contains(nei)) {
                        q2.offer(nei);
                        set2.add(nei);
                    }
                }
            }
            dist2++;
        }
        
        return -1;
    }
}