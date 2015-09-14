/** Binary Tree Paths **/
/*=======================================================
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

=======================================================*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null) return res;
        String temp = new String();
        helper(root,temp,res);
        return res;
    }
    
    public void helper(TreeNode root, String temp, List<String> res){
        if(root.left==null&&root.right==null){
            temp = temp+String.valueOf(root.val);
            res.add(temp);
            return;
        }
        if(root.left!=null){
            helper(root.left,temp+String.valueOf(root.val)+"->",res);
        }
        if(root.right!=null){
            helper(root.right,temp+String.valueOf(root.val)+"->",res);
        }
        return;
    }
}