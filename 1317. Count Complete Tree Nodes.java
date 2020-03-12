1317. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Example
Example1

Input: {1,2,3,4,5,6}
Output: 6
Explanation: 
    1
   / \
  2   3
 / \  /
4  5 6
Example2

Input: {1,2,3,4,5,6,8}
Output: 7
Explanation: 
    1
   / \
  2   3
 / \  /\
4  5 6  8
Notice
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.


//divide & conquer
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
     * @param root: root of complete binary tree
     * @return: the number of nodes
     */
    public int countNodes(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        
        return left + right + 1;
    }
}