85. Insert Node in a Binary Search Tree
Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

Example
Example 1:
	Input:  tree = {}, node = 1
	Output:  1
	
	Explanation:
	Insert node 1 into the empty tree, so there is only one node on the tree.

Example 2:
	Input: tree = {2,1,4,3}, node = 6
	Output: {2,1,4,3,6}
	
	Explanation: 
	Like this:



	  2             2
	 / \           / \
	1   4   -->   1   4
	   /             / \ 
	  3             3   6
		
Challenge
Can you do it without recursion?

Notice
You can assume there is no duplicate values in this tree + node.


//iteration
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
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        TreeNode head = root;
        while (root != null) {
            if (root.val < node.val) {
                if (root.right != null) {
                    root = root.right;
                }
                else {
                    root.right = node;
                    return head;
                }
            }
            else if (root.val > node.val) {
                if (root.left != null) {
                    root = root.left;
                }
                else {
                    root.left = node;
                    return head;
                }
            }
        }
        
        return head;
    }
}


//recursion
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
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        }
        else if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        }
        
        return root;
    }
}