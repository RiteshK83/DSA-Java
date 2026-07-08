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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;

    }
    private void dfs(TreeNode node, String path, List<String> ans){
        if(node == null){
            return;
        }
        path = path.isEmpty()
       ? String.valueOf(node.val)
       : path + "->" + node.val;

       if(node.left == null && node.right == null){
        ans.add(path);
        return;
       }
       dfs(node.left,path,ans);
       dfs(node.right, path,ans);
    }
}