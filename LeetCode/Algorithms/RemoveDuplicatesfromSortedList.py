# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        point = head
        while point is not None and point.next is not None:
            if point.val == point.next.val:
                point.next = point.next.next
            else:
                point = point.next
        return head