7. Serialize and Deserialize Binary Tree
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

Example
Example 1:

Input：{3,9,20,#,#,15,7}
Output：{3,9,20,#,#,15,7}
Explanation：
Binary tree {3,9,20,#,#,15,7},  denote the following structure:
	  3
	 / \
	9  20
	  /  \
	 15   7
it will be serialized {3,9,20,#,#,15,7}
Example 2:

Input：{1,2,3}
Output：{1,2,3}
Explanation：
Binary tree {1,2,3},  denote the following structure:
   1
  / \
 2   3
it will be serialized {1,2,3}
Our data serialization use BFS traversal. This is just for when you got Wrong Answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Notice
There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.

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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String ans = new String();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        ans = "";
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans += "#";
            }
            else {
                ans += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
            ans += ",";
        }
        
        int len = ans.length()-1;
        while (ans.charAt(len) == '#' || ans.charAt(len) == ',') {
            len--;
        }
        
        return ans.substring(0, len+1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);
        int index = 1;
        while (index < str.length && !q.isEmpty()) {
            TreeNode node = q.poll();
            
            if (str[index].equals("#")) {
                node.left = null;
            }
            else {
                node.left = new TreeNode(Integer.parseInt(str[index]));
                q.offer(node.left);
            }
            index++;
            if (index == str.length) {
                break;
            }
            
            if (str[index].equals("#")) {
                node.right = null;
            }
            else {
                node.right = new TreeNode(Integer.parseInt(str[index]));
                q.offer(node.right);
            }
            index++;
        }
        
        return root;
    }
}