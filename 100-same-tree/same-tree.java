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
    private String serialize(TreeNode root){
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null){
                sb.append("null").append(",");
                continue;
            }
            sb.append(node.val);
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        String str1 = serialize(p);
        String str2 = serialize(q);

        return str1.equals(str2);
    }
}