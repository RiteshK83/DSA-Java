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
    public int minDepth(TreeNode root) {
        return depth(root);
    }
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);

        if(left == 0){
            return right +1;

        }
        if(right == 0){
            return left+1;
        }
        return Math.min(left,right)+1;
    }
}