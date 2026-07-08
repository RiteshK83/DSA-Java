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
    int preIndex = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0,inorder.length-1,preorder);
    } 
        
        private TreeNode build(int left, int right, int[] preorder){
            if(left>right){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preIndex]);
            preIndex++;

            int mid = map.get(root.val);

            root.left = build(left,mid-1,preorder);
            root.right = build(mid+1, right, preorder);

            return root;


        }
          
    }
