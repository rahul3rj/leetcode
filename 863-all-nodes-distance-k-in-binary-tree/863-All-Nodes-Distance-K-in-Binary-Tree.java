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
    private void markParent(TreeNode root, Map<TreeNode, TreeNode> parents, TreeNode target){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParent(root, parents, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target, true);
        int curr = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr == k) break;
            curr++;
            for(int i = 0; i< size; i++){
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parents.get(current) != null && visited.get(parents.get(current)) == null){
                    q.offer(parents.get(current));
                    visited.put(parents.get(current), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            res.add(current.val);
        }
        return res;
    }
}