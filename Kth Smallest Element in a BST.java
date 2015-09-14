/** Kth Smallest Element in a BST **/
/*================================================================================================================================
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
================================================================================================================================*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 中序traversal 
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int count=0;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            count++;
            if(count==k){
                return temp.val;
            }
            if(temp.right!=null){
                root = temp.right;
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }
            }
            
            
        }
        return 0;
    }
    
}