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
    int ans  = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gain(root);
        return ans;
    }
    private int gain(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,gain(node.left));
        int right = Math.max(0,gain(node.right));

        ans = Math.max(ans,left+right+node.val);

        return node.val +Math.max(left,right);


    }

}