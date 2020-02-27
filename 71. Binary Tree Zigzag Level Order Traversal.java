71. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
Example 1:

Input:{1,2,3}
Output:[[1],[3,2]]
Explanation:
    1
   / \
  2   3
it will be serialized {1,2,3}
Example 2:

Input:{3,9,20,#,#,15,7}
Output:[[3],[20,9],[15,7]]
Explanation:
    3
   / \
  9  20
    /  \
   15   7
it will be serialized {3,9,20,#,#,15,7}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        boolean reverse = false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            ans.add(list);
        }
        
        return ans;
    }
}