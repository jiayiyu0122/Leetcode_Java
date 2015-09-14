/* Binary Tree Right Side
       1       <----
      / \
     2   3     <----
    /     
   5           <----

   You should return [1,3,4]
*/

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
    
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> sideView = new ArrayList<Integer>();
        if(root==null) return sideView;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove(0);
                if(i==0){
                    sideView.add(node.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
            }
            
        }
        return sideView;
        
 }
}