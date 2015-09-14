/** Binary Tree Level Order Traversal **/
/*==============================================================================================================
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

==============================================================================================================*/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
                
                
            }
            res.add(temp);
        }
        
        return res;
    }
}