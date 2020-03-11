691. Recover Binary Search Tree
In a binary search tree, (Only) two nodes are swapped. Find out these nodes and swap them. If there no node swapped, return original root of tree.

Example
Example1

Input: {4,5,2,1,3}
Output: {4,2,5,1,3}
Explanation:
Given a binary search tree:
    4
   / \
  5   2
 / \
1   3
return 
    4
   / \
  2   5
 / \
1   3
Example2

Input: {1,2,5,4,3}
Output: {4,2,5,1,3}
Given a binary search tree:
    1
   / \
  2   5
 / \
4   3
return 
    4
   / \
  2   5
 / \
1   3

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
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        TreeNode head = root;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        TreeNode first = null, second = null;
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (prev != null && prev.val > node.val) {
                if (first == null) {
                    first = prev;
                    second = node;
                }
                else {
                    second = node;
                    break;
                }
            }
            prev = node;
            
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
        if (first != null) {
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }
        
        return head;
    }
}