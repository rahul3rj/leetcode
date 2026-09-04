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
    List <Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        Inorder(root);
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            if(list.get(l) + list.get(r) == k){
                return true;
            }
            if(list.get(l) + list.get(r) > k){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
    public void Inorder(TreeNode root){
        if(root == null) return;
        Inorder(root.left);
        list.add(root.val);
        Inorder(root.right);
    }
}