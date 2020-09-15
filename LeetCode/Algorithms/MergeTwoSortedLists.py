# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        jump = ListNode(0)
        head = jump
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                jump.next = l1
                l1 = l1.next
            else:
                jump.next = l2
                l2 = l2.next
            jump = jump.next
        if l1 == None:
            jump.next = l2
        else:
            jump.next = l1
        return head.next