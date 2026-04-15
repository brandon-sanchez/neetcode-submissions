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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Create a dummy node to handle edge cases gracefully,
        // such as removing the head node itself
        ListNode dummy = new ListNode(0, head);

        // Initialize two pointers:
        // 'left' starts at dummy, and 'right' starts at head
        ListNode left = dummy;
        ListNode right = head;

        // Step 2: Move 'right' n steps ahead so there's a gap of n between 'left' and 'right'
        while (n > 0) {
            right = right.next;
            n--;
        }

        // Step 3: Move both pointers forward together until 'right' reaches the end
        // At this point, 'left' will be just before the node to remove
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Step 4: Skip the node to be removed
        // If 'left' is pointing to node before target, skip left.next
        left.next = left.next.next;

        // Step 5: Return the new head of the list (which may have changed if head was removed)
        return dummy.next;
    }
}