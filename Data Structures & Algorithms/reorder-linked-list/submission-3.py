# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:

        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the 2nd half of the list
        prev, curr = None, slow.next

        # Cut off first half from 2nd half
        slow.next = None


        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        node1, node2 = head, prev

        while node1 and node2:
            # Save next nodes
            next1 = node1.next
            next2 = node2.next

            # Re-wire current nodes
            node1.next = node2
            node2.next = next1

            # Move pointers forward
            node1 = next1
            node2 = next2



        

