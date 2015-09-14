/** Binary Tree Zigzag Level Order Traversal  **/
/*=================================================================================================================================
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
==================================================================================================================================*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        queue.offer(root);
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        res.add(temp);
        int level = 1;
        while(!queue.isEmpty()){
            temp = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                    temp.add(cur.left.val);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                    temp.add(cur.right.val);
                }
            }
            if(!temp.isEmpty()){
                if(level%2==0){
                    res.add(temp);
                }
                else{
                    Collections.reverse(temp);
                    res.add(temp);
                }
            }
            
            level++;
        }
        return res;
    }
}