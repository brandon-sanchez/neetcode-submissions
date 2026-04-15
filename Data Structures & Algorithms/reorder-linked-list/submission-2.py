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

        # Cut off middle and reverse the list
        second_half = slow.next
        slow.next = None
        prev = None

        while second_half:
            temp = second_half.next
            second_half.next = prev
            prev = second_half
            second_half = temp
        
        first_list, second_list = head, prev
        while first_list and second_list:
            temp1, temp2 = first_list.next, second_list.next
            first_list.next = second_list
            second_list.next = temp1
            first_list, second_list = temp1, temp2
