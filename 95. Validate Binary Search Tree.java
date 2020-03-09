95. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Example
Example 1:

Input:  {-1}
Output：true
Explanation：
For the following binary tree（only one node）:
	      -1
This is a binary search tree.
Example 2:

Input:  {2,1,4,#,#,3,5}
Output: true
For the following binary tree:
	  2
	 / \
	1   4
	   / \
	  3   5
This is a binary search tree.


//recursion, divide & conquer, bottom-up
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    class resultType {
        boolean valid;
        int min;
        int max;
        resultType(int min, int max) {
            this.min = min;
            this.max = max;
            this.valid = true;
        }
    } 
    
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        resultType ans = dfs(root);
        return ans.valid;
    }
    
    private resultType dfs(TreeNode root) {
        if (root == null) {
            return new resultType(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        resultType ans = new resultType(root.val, root.val);
        resultType left = dfs(root.left);
        resultType right = dfs(root.right);
        
        if (!left.valid || !right.valid) {
            ans.valid = false;
            return ans;
        }
        
        if (root.left != null)  {
            ans.valid = (left.max < root.val);
            ans.min = left.min;
        }
        if (root.right != null) {
            ans.valid = (right.min > root.val);
            ans.max = right.max;
        }
        
        return ans;
    }
}

//recursion, divide & conquer, top-down
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        boolean left = dfs(root.left, min, root.val);
        boolean right = dfs(root.right, root.val, max);
        
        return left & right;
    }
}

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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (prev != null && prev.val >= node.val) {
                return false;
            }
            prev = node;
            
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            else {
                node = stack.pop();
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                }
            }
        }
        
        return true;
    }
}
