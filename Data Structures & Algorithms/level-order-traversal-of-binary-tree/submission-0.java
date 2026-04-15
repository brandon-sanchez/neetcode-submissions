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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        //level order traversal = breadth first search
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        // left - root - right
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            //For every node on the same level
            for(int i = queue.size(); i > 0; i--) {
                //Take the node in first place in the queue
                TreeNode node = queue.poll();
                if(node != null) {
                    //add node val to level list
                    level.add(node.val);

                    //add left and right nodes of current node to queue
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            //Add list to arraylist
            if(level.size() > 0) {
                result.add(level);
            }
        }

        return result;
    }
}
