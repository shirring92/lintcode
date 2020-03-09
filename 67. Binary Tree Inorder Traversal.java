67. Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

Example
Example 1:

Input：{1,2,3}
Output：[2,1,3]
Explanation:
   1
  / \
 2   3
it will be serialized {1,2,3}
Inorder Traversal
Example 2:

Input：{1,#,2,3}
Output：[1,3,2]
Explanation:
1
 \
  2
 /
3
it will be serialized {1,#,2,3}
Inorder Traversal
Challenge
Can you do it without recursion?

//recursion. in order traversal
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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        dfs(root, ans);
        
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        
        return ans;
    }
}