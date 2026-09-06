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
class NodeValue{
    public int maxNode, minNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
class Solution {
    private int maxSum = 0;
    private NodeValue helper(TreeNode root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if(left.maxNode < root.val && root.val < right.minNode){
            int curr = left.maxSize + right.maxSize + root.val;
            maxSum = Math.max(maxSum, curr);

            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode), curr);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        helper(root);
        return maxSum;
    }
}