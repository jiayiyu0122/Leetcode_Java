/** Flatten Binary Tree to Linked List **/
/*======================================================================
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
==============================================================================*/

// equvilent to a preorder traversal

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
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
 
        while(cur!=null || !stack.isEmpty()){
          
            
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
               cur.right = cur.left;
               cur.left = null;
            }  
            else if(!stack.isEmpty()){
                TreeNode temp = stack.pop();
                cur.right = temp;
            }
            
            
            cur = cur.right;    
            
        }
        
        return;
    }
}