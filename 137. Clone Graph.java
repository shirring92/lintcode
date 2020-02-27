137. Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. Nodes are labeled uniquely.

You need to return a deep copied graph, which has the same structure as the original graph, and any changes to the new graph will not have any effect on the original graph.

Example
Example1

Input:
{1,2,4#2,1,4#4,1,2}
Output: 
{1,2,4#2,1,4#4,1,2}
Explanation:
1------2  
 \     |  
  \    |  
   \   |  
    \  |  
      4   
Clarification
How we serialize an undirected graph: http://www.lintcode.com/help/graph/

Notice
You need return the node with the same label as the input node.



/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
		if (node == null) {
			return null;
		}
		
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.offer(node);
		map.put(node.label, new UndirectedGraphNode(node.label));
		while (!q.isEmpty()) {
			UndirectedGraphNode curr = q.poll();
			for (UndirectedGraphNode next: curr.neighbors) {
				if (!map.containsKey(next.label)) {
					q.offer(next);
					map.put(next.label, new UndirectedGraphNode(next.label));
				}
				map.get(curr.label).neighbors.add(map.get(next.label));
			}
		}
		
		return map.get(node.label);
	}
}