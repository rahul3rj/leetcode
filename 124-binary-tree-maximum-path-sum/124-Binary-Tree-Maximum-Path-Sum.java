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
    private int path = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return path;
    }
    public int pathSum(TreeNode node){
        if(node == null) return 0;
        int leftP = Math.max(0, pathSum(node.left));
        int rightP = Math.max(0, pathSum(node.right));
        path = Math.max(path, leftP + rightP + node.val);
        return node.val + Math.max(leftP, rightP);
    }
}