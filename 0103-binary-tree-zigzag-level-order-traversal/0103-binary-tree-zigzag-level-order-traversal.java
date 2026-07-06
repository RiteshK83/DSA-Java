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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
           int levelSize = q.size();

           List<Integer> currLevel = new ArrayList<>();

           for(int i =0; i< levelSize; i++){
            TreeNode curr = q.poll();


            if(leftToRight){
                currLevel.add(curr.val);
            }
            else{
                currLevel.add(0,curr.val);
            }

            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null){
                q.offer(curr.right);
            }

           }
           ans.add(currLevel);

           leftToRight =  !leftToRight;
        }
        return ans;
    }
}