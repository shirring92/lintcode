1506. All Nodes Distance K in Binary Tree
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node. The answer can be returned in any order.

Example
Example 1:

Input:
{3,5,1,6,2,0,8,#,#,7,4}
5
2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.
img

Example 2

Input:
{1,2,3,4}
2
1

Output: [1,4]

Explanation:
The binary tree is like this:
    1
   / \
  2   3
 /   
4   
The node 1 and 4 is 1 away from 2.
Notice
The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.


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
     * @param root: the root of the tree
     * @param target: the target
     * @param K: the given K
     * @return: All Nodes Distance K in Binary Tree
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        
        HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        map.put(root, null);
        build(root, map);
        
        Set<TreeNode> set = new HashSet<TreeNode>();
        TreeNode parent = target;
        while (parent != null) {
            find(parent, K, set, ans);
            parent = map.get(parent);
            K--;
        }
        
        return ans;
    }
    
    private void build(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            map.put(root.left, root);
            build(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, root);
            build(root.right, map);
        }
    }
    
    private void find(TreeNode root, int K, Set<TreeNode> set, List<Integer> ans) {
        if (root == null) {
            return;
        }

        set.add(root);
        if (K == 0) {
            ans.add(root.val);
            return;
        }
        
        if (!set.contains(root.left)) {
            find(root.left, K-1, set, ans);
        }
        if (!set.contains(root.right)) {
            find(root.right, K-1, set, ans);
        }
        
    }
}