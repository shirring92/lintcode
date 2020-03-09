86. Binary Search Tree Iterator
Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Example
Example 1

Input:  {10,1,11,#,6,#,12}
Output:  [1, 6, 10, 11, 12]
Explanation:
The BST is look like this:
  10
  /\
 1 11
  \  \
   6  12
You can return the inorder traversal of a BST [1, 6, 10, 11, 12]
Example 2

Input: {2,1,3}
Output: [1,2,3]
Explanation:
The BST is look like this:
  2
 / \
1   3
You can return the inorder traversal of a BST tree [1,2,3]
Challenge
Extra memory usage O(h), h is the height of the tree.

Super Star: Extra memory usage O(1)


//iteration + stack, space O(h)
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        TreeNode ans = node;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        //System.out.println(ans.val);
        
        return ans;
    }
}


//O(1) space need to use morris traversal