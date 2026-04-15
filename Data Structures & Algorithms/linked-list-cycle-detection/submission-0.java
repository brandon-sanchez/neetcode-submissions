/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        //Declare a new hashset to store ListNodes that we've already have seen
        HashSet<ListNode> hashset = new HashSet<>();

        //Make the currentNode be the start of the linked list
        ListNode currentNode = head;

        /**
        While the currentNode is not Null:
        - Check to see if the hashset contains the current node (if we've already seen or been to the current ListNode)
            -IF SO, RETURN TRUE
        - Add the currentNode to the hashset if it has not been seen yet and move to the next ListNode in the linked list
        **/
        while(currentNode != null) {
            if(hashset.contains(currentNode)) {
                return true;
            }
            hashset.add(currentNode);
            currentNode = currentNode.next;
        }

        //If none of that happens, then we know it doesn't have a cycle and we can return false
        return false;

    }
}
