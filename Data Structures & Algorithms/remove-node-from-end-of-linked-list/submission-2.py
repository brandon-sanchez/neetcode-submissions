# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        dummy = ListNode(0, head)

        prev, curr = dummy, head

        while n > 0:
            curr = curr.next
            n -= 1
        
        while curr:
            prev = prev.next
            curr = curr.next
        
        # We want the end node to connect to the node after its next one
        prev.next = prev.next.next

        return dummy.next