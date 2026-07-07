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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        dfs(root,targetSum,path,ans);
        return ans;
    }

        private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> ans){
            if(node == null){
                return;
            }
            path.add(node.val);
            target -=node.val;

            if(node.left == null && node.right == null){
                if(target==0){
                    ans.add(new ArrayList<>(path));
                }
            }
                else{
                    dfs(node.left,target,path,ans);
                    dfs(node.right,target,path,ans);
                }
            
            path.remove(path.size() -1);
        
        
    }
}