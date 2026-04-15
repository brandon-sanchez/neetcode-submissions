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
    public ListNode reverseList(ListNode head) {

        //Start previous pointer to be null
        ListNode previous = null;
        //Set the current pointer to the head of the current linked list
        ListNode current = head;


        /**
            While the current pointer is not null (at end of the linked list)

            -Store the next node before we break the chain
            -Then link the current node to the previous node
            -Then move the previous node up 1 to be the next node
            -Then move the current node to the next node (the stored node)
        **/
        while(current != null) {
            ListNode storedNextNode = current.next;
            current.next = previous;
            previous = current;
            current = storedNextNode;
        }

        //At the end the previous pointer will be the new head of the linked list
        return previous;
    }
}
