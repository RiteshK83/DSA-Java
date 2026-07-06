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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }
    private boolean dfs(TreeNode node, int target){
        if(node == null){
            return false;
        }
        target = target - node.val;

        if(node.left == null && node.right == null){
            return target ==0;
        }
        return dfs(node.left, target) || dfs(node.right, target);
    }
}