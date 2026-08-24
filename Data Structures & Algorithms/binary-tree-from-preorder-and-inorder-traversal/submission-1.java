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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store value-to-index mappings of inorder elements for O(1) time lookups.
        // HashMap raw type updated to Integer, Integer for type safety.
        Map<Integer, Integer> inMap = new HashMap<>();
        
        // Loop through the inorder array and populate the map.
        // Example: if inorder[0] = 9, map stores key=9, value=0.
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        // Kick off recursive tree construction covering the full range of both arrays:
        // preorder starts at 0 and ends at preorder.length - 1
        // inorder starts at 0 and ends at inorder.length - 1
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
                               int[] inorder, int inStart, int inEnd, 
                               Map<Integer, Integer> inMap) {
        
        // BASE CASE: If boundary pointers cross each other, the current subtree is empty.
        // Return null to signify a leaf node's child.
        if (preStart > preEnd || inStart > inEnd) return null;

        // RULE 1: The first element in the current preorder sub-array is ALWAYS the root node.
        TreeNode root = new TreeNode(preorder[preStart]);

        // RULE 2: Find the root's position inside the inorder array using our map.
        // Elements to the left of inRoot belong to the left subtree.
        // Elements to the right of inRoot belong to the right subtree.
        int inRoot = inMap.get(root.val);

        // Calculate how many nodes exist in the left subtree.
        // Formula: root_index_in_inorder - start_index_of_current_inorder_range
        int numsLeft = inRoot - inStart;

        // RECURSION - LEFT SUBTREE:
        // - Preorder range: starts right after root (preStart + 1) up to (preStart + numsLeft).
        // - Inorder range: starts at current inStart up to just before root (inRoot - 1).
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, 
                              inorder, inStart, inRoot - 1, inMap);

        // RECURSION - RIGHT SUBTREE:
        // - Preorder range: starts after left subtree nodes (preStart + numsLeft + 1) up to preEnd.
        // - Inorder range: starts right after root (inRoot + 1) up to current inEnd.
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, 
                               inorder, inRoot + 1, inEnd, inMap);

        // Return the reconstructed node (and its subtrees attached) to its parent.
        return root;
    }
}