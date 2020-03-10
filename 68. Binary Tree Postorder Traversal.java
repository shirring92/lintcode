68. Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

Example
Example 1:

Input：{1,2,3}
Output：[2,3,1]
Explanation:  
   1
  / \
 2   3
 it will be serialized {1,2,3}
Post order traversal
Example 2:

Input：{1,#,2,3}
Output：[3,2,1]
Explanation:  
1
 \
  2
 /
3
it will be serialized {1,#,2,3}
Post order traversal
Challenge
Can you do it without recursion?

Notice
The first data is the root node, followed by the value of the left and right son nodes, and "#" indicates that there is no child node.
The number of nodes does not exceed 20.



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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            int size = stack.size();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            
            if (stack.size() == size) {
                node = stack.pop();
                ans.add(node.val);
                while (!stack.isEmpty() && (node == stack.peek().right || node == stack.peek().left)) {
                    node = stack.pop();
                    ans.add(node.val);
                }
            }
        }
        
        return ans;
    }
}


//traversal
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
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
        dfs(root.right, ans);
        ans.add(root.val);
    }
}

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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        ans.addAll(left);
        ans.addAll(right);
        ans.add(root.val);
        
        return ans;
    }
}