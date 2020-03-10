900. Closest Binary Search Tree Value
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Example
Example1

Input: root = {5,4,9,2,#,8,10} and target = 6.124780
Output: 5
Explanation：
Binary tree {5,4,9,2,#,8,10},  denote the following structure:
        5
       / \
     4    9
    /    / \
   2    8  10
Example2

Input: root = {3,2,4,1} and target = 4.142857
Output: 4
Explanation：
Binary tree {3,2,4,1},  denote the following structure:
     3
    / \
  2    4
 /
1
Notice
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.


//recursion. traversal. O(h) + O(1)
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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    TreeNode node;
    public int closestValue(TreeNode root, double target) {
        // write your code here
        node = root;
        dfs(root, target);
        
        return node.val;
    }
    
    private void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        
        if ((double)root.val == target) {
            node = root;
            return;
        }
        
        double min = (double) node.val - target;
        double diff = (double) root.val - target;
        if (Math.abs(min) > Math.abs(diff)) {
            node = root;
        }
        if (root.val < target) {
            dfs(root.right, target);
        }
        else if (root.val > target) {
            dfs(root.left, target);
        }
    }
}