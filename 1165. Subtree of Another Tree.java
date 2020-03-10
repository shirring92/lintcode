1165. Subtree of Another Tree
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example
Example 1:

Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:

Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

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
     * @param s: the s' root
     * @param t: the t' root
     * @return: whether tree t has exactly the same structure and node values with a subtree of s
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Write your code here
        if (s == null) {
            return t == null;
        }
        
        if(t == null) {
            return false;
        }
        
        if (s.val == t.val && equal(s, t)) {
            return true;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean equal(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        
        if (t == null || s.val != t.val) {
            return false;
        }
        
        return equal(s.left, t.left) && equal(s.right, t.right);
    }
}