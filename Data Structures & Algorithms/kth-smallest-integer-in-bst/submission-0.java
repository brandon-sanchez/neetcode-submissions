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
    public int kthSmallest(TreeNode root, int k) {
        // Stack to simulate the in-order traversal (iterative)
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // Continue traversal while there are nodes left to visit
        while (!stack.isEmpty() || curr != null) {

            // Go as left as possible, pushing all nodes onto the stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop the node from the stack (smallest unvisited node)
            curr = stack.pop();
            k--; // Decrement k; we found the next smallest node

            // If k == 0, we've reached the kth smallest node
            if (k == 0) {
                return curr.val;
            }

            // Move to the right subtree (in-order: left → node → right)
            curr = curr.right;
        }

        // Should never be hit if input is valid, but needed to compile
        return -1;
    }
}
