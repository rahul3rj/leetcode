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
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        length(root, diameter);
        return diameter[0];
    }
    public int length(TreeNode node, int[] maxi){
        if(node == null) return 0;

        int leftH = length(node.left, maxi);
        int rightH = length(node.right, maxi);
        maxi[0] = Math.max(maxi[0], leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}