/** Path Sum **/
/*================================================================================================
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
================================================================================================*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 注意要考虑到有负数的情况
// 这样就不能单纯的用root.val小于sum的情况进行剪枝了
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return helper(root,sum);
        
    }
    
    public boolean helper(TreeNode root, int sum){
        if(root==null&&sum!=0) return false;
        if(root==null&&sum==0) return true;
        if(root.right==null){
            return helper(root.left,sum-root.val);
        }
        if(root.left==null){
            return helper(root.right,sum-root.val);
        }
        
        return helper(root.left,sum-root.val)||helper(root.right,sum-root.val);
        
        
    }
}