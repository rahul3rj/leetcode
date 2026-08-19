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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
       return check(root.right, root.left);
    }
    public boolean check(TreeNode r, TreeNode l){
        if(r == null && l == null) return true;
        if(r == null || l == null) return false;
        if(r.val == l.val && check(r.left, l.right) && check(r.right, l.left)) return true;
        return false;
    }
}