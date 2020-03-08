88. Lowest Common Ancestor of a Binary Tree
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Example
Example 1:

Input：{1},1,1
Output：1
Explanation：
 For the following binary tree（only one node）:
         1
 LCA(1,1) = 1
Example 2:

Input：{4,3,7,#,#,5,6},3,5
Output：4
Explanation：
 For the following binary tree:

      4
     / \
    3   7
       / \
      5   6
			
 LCA(3, 5) = 4
Notice
Assume two nodes are exist in tree.

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



//divide & conquer, this solution is too complicated
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
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
            ans = left;
        } 
        else if (right.node != null) {
            ans = right;
        }
        else {
            if (left.a || right.a) {
                ans.a = true;
            }
            if (left.b || right.b) {
                ans.b = true;
            }
            if (ans.a && ans.b) {
                ans.node = root;
            }
            else if (ans.a) {
                if (root == B) {
                    ans.b = true;
                }
            }
            else if (ans.b) {
                if (root == A) {
                    ans.a = true;
                }
            }
            else {
                if (root == A) {
                    ans.a = true;
                }
                if (root == B) {
                    ans.b = true;
                }
            }
            if (ans.a && ans.b) {
                ans.node = root;
            }
        }
        
        return ans;
    }
}


//divide & conquer. this solution assume two nodes must be exist in the tree
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
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null) {
            return root;
        }
        // if one node is ancestor of another node, it will return once it finds the ancestor
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        
        return null;
    }
}