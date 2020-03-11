72. Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.

Example
Example 1:

Input：[],[]
Output：{}
Explanation:
The binary tree is null
Example 2:

Input：[1,2,3],[1,3,2]
Output：{2,1,3}
Explanation:
The binary tree is as follows
  2
 / \
1   3

Notice
You may assume that duplicates do not exist in the tree.


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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        
        TreeNode root = dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
        return root;
    }
    
    private TreeNode dfs(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }
        
        int val = postorder[e2];
        TreeNode root = new TreeNode(val);
        
        for (int i=s1; i<=e1; i++) {
            if (inorder[i] == val) {
                root.left = dfs(inorder, s1, i - 1, postorder, s2, i - s1 + s2 - 1);
                root.right = dfs(inorder, i + 1, e1, postorder, i - s1 + s2, e2 - 1);
                break;
            }
        }
        
        return root;
    }
}