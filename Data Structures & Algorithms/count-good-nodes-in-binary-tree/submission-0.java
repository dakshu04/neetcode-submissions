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
    private int maxGoodCount = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return maxGoodCount;
    }
    public void dfs(TreeNode root, int maxSoFar) {
        if(root.val >= maxSoFar) {
            maxGoodCount++;
        }
        if(root.left != null) {
            dfs(root.left, Math.max(maxSoFar, root.val));
        }
        if(root.right != null) {
            dfs(root.right, Math.max(maxSoFar, root.val));
        }
    }
}
