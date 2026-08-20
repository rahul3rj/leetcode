/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode leftC = lowestCommonAncestor(root.left, p, q);
        TreeNode rightC = lowestCommonAncestor(root.right, p, q);
        if(leftC == null){
            return rightC;
        }
        else if(rightC == null){
            return leftC;
        }else{
            return root;
        }
    }
}