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
    public void reorderList(ListNode head) {
        // Edge case: empty list or only one element, no need to reorder
        if (head == null || head.next == null) return;

        // Step 1: Use fast and slow pointer to find the middle of the list
        ListNode slow = head;
        ListNode fast = head.next;

        // Move fast by two steps and slow by one step
        // When fast reaches the end, slow will be at the midpoint
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list into two halves
        // The second half starts from the node after 'slow'
        ListNode secondHalf = slow.next;

        // Cut off the first half of the list at the midpoint
        // Also initialize 'prev' pointer for reversing the second half
        ListNode prev = slow.next = null;

        // Step 3: Reverse the second half of the list
        // This will allow us to interleave nodes from start and end
        while (secondHalf != null) {
            ListNode nextNode = secondHalf.next;  // Temporarily store next node
            secondHalf.next = prev;               // Reverse current node's pointer
            prev = secondHalf;                    // Move prev forward
            secondHalf = nextNode;                // Move to next node in original second half
        }

        // After the loop, 'prev' points to the head of the reversed second half
        // Example: 1 → 2 → 3 → 4 → 5 becomes 1 → 2 → 3 and 5 → 4 (reversed)

        // Step 4: Merge the two halves together
        ListNode firstHalf = head;
        secondHalf = prev;  // Now this is the head of the reversed second half

        while (secondHalf != null) {
            // Save next nodes temporarily
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            // Interleave one node from each half
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            // Move both pointers forward
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}