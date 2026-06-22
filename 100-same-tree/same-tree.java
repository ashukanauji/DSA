/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode node1 = p;
        TreeNode node2 = q;


        if(node1 == null || node2 == null || (node1.val != node2.val)){
            if(node1 == null && node2 == null)
                return true;
            return false;
        }
            // return false;

        boolean leftResult = isSameTree(p.left, q.left);
        boolean rightResult = isSameTree(p.right, q.right);
        

        return leftResult && rightResult;        
    }
}