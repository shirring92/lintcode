578. Lowest Common Ancestor III
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

Example
Example1

Input: 
{4, 3, 7, #, #, 5, 6}
3 5
5 6
6 7 
5 8
Output: 
4
7
7
null
Explanation:
  4
 / \
3   7
   / \
  5   6

LCA(3, 5) = 4
LCA(5, 6) = 7
LCA(6, 7) = 7
LCA(5, 8) = null

Example2

Input:
{1}
1 1
Output: 
1
Explanation:
The tree is just a node, whose value is 1.
Notice
node A or node B may not exist in tree.
Each node has a different value


//
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
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    class resultType {
        boolean a, b;
        TreeNode node;
        resultType(boolean a, boolean b, TreeNode node) {
            this.a = a;
            this.b = b;
            this.node = node;
        }
    }
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        return dfs(root, A, B).node;
    }
    
    private resultType dfs(TreeNode root, TreeNode A, TreeNode B) {
        resultType ans = new resultType(false, false, null);
        if (root == null) {
            return ans;
        }
        
        resultType left = dfs(root.left, A, B);
        resultType right = dfs(root.right, A, B);
        
        if (left.node != null) {
            return left;
        }
        if (right.node != null) {
            return right;
        }
        
        ans.a = left.a || right.a || root == A;
        ans.b = left.b || right.b || root == B;

        if (ans.a && ans.b) {
            ans.node = root;
        }
        
        return ans;
    }
}