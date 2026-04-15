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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Dummy node to start the list
        ListNode dummy = new ListNode(0);

        ListNode node = dummy;

        //Compare the values and add lowest first to dummy node list.
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        //Want to make sure we can just add remaining values if one list is bigger than other
        if(list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        //ListNode head = node.next;
        return dummy.next;

    }
}