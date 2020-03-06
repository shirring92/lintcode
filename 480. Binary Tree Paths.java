480. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

Example
Example 1:

Input：{1,2,3,#,5}
Output：["1->2->5","1->3"]
Explanation：
   1
 /   \
2     3
 \
  5
Example 2:

Input：{1,2}
Output：["1->2"]
Explanation：
   1
 /   
2     


//traverse
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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        String s = "";
        dfs(root, s, ans);
        
        return ans;
    }
    
    private void dfs(TreeNode root, String s, List<String> ans) {
        if (root.left == null && root.right == null) {
            s += root.val;
            ans.add(s);
            return;
        }
        
        s += root.val + "->";
        if (root.left != null) {
            dfs(root.left, s, ans);
        }
        if (root.right != null) {
            dfs(root.right, s, ans);
        }
    }
}