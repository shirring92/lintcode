448. Inorder Successor in BST
Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

Example
Example 1:

Input: {1,#,2}, node with value 1
Output: 2
Explanation:
  1
   \
    2
Example 2:

Input: {2,1,3}, node with value 1
Output: 2
Explanation: 
    2
   / \
  1   3
Binary Tree Representation

Challenge
O(h), where h is the height of the BST.

Notice
It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)

//iteration, O(h) + O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        TreeNode prev = null;
        while (root != null) {
            if (root.val > p.val) {
                prev = root;
                root = root.left;
            }
            else if (root.val < p.val) {
                root = root.right;
            }
            else {
                if (root.right != null) {
                    TreeNode right = root.right;
                    while (right.left != null) {
                        right = right.left;
                    }
                    return right;
                }
                else {
                    return prev;
                }
            }
        }
        
        return null;
    }
}