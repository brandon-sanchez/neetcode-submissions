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
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Assigning the start of second half of linked list to be slow.next
        ListNode secondHalf = slow.next;

        //slow.next = null cuts the list into two halves  by setting the next pointer
        // of the middle node (slow) to null. Now, since slow.next is already set to null, it sets its 
        ListNode previousNode = slow.next = null;

        //Now we want to reverse all the links in the second half of list
        while(secondHalf != null) {
            ListNode tempNextNode = secondHalf.next;
            secondHalf.next = previousNode;
            previousNode = secondHalf;
            secondHalf = tempNextNode;
        }


        // Now we want to merge both the lists
        ListNode firstHalf = head;
        secondHalf = previousNode;

        while(secondHalf != null) {
            ListNode tempNextNode1 = firstHalf.next;
            ListNode tempNextNode2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = tempNextNode1;

            firstHalf = tempNextNode1;
            secondHalf = tempNextNode2;
        }
    }
}
