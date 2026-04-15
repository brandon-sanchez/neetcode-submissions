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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        for(int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                currNode.next = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                list2 = list2.next;
            }

            currNode = currNode.next;
        }

        if(list1 != null) {
            currNode.next = list1;
        } else {
            currNode.next = list2;
        }

        return dummy.next;
    }
}
