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
    int postIndex;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length -1;
        for(int i =0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(0,inorder.length-1, postorder);
    }
    private TreeNode build(int left, int right, int[] postorder){
        if(left> right){
            return null;
        }
        TreeNode root = new TreeNode (postorder[postIndex]);
        postIndex--;

        int mid = map.get(root.val);

        root.right = build(mid+1, right,postorder);
        root.left = build(left,mid-1,postorder);

        return root;
    }
}