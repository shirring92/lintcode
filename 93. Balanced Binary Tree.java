93. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
Example  1:
	Input: tree = {1,2,3}
	Output: true
	
	Explanation:
	This is a balanced binary tree.
		  1  
		 / \                
		2  3

	
Example  2:
	Input: tree = {3,9,20,#,#,15,7}
	Output: true
	
	Explanation:
	This is a balanced binary tree.
		  3  
		 / \                
		9  20                
		  /  \                
		 15   7 

	
Example  3:
	Input: tree = {1,#,2,3,4}
	Output: false
	
	Explanation:
	This is not a balanced tree. 
	The height of node 1's right sub-tree is 2 but left sub-tree is 0.
		  1  
		   \                
		   2                
		  /  \                
		 3   4
	

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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    class resultType {
        int depth;
        boolean balance;
        resultType(int depth, boolean balance) {
            this.depth = depth;
            this.balance = balance;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return dfs(root).balance;
    }
    
    private resultType dfs(TreeNode root) {
        if (root == null) {
            return new resultType(0, true);
        }
        
        resultType left = dfs(root.left);
        resultType right = dfs(root.right);
        
        resultType ans = new resultType(0, false);
        if (left.balance && right.balance) {
            ans.balance = Math.abs(left.depth - right.depth) <= 1;
        }
        ans.depth = Math.max(left.depth, right.depth) + 1;
        
        return ans;
    }
}