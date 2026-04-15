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
        ListNode previous = null;
        ListNode current = head;

        while(current != null){
            ListNode temp = current.next;

            // make current node point to previous node
            current.next = previous;
            
            //increment next and previous nodes by one
            previous = current;
            current = temp;
        }

        return previous;
    }
}
