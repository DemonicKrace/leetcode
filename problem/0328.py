# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # method 1, loop to iterate, time = O(N), space = O(1)
        evenHead = head.next if head else None
        oddPtr, evenPtr = head, evenHead
        while evenPtr and evenPtr.next:
            oddPtr.next = evenPtr.next
            oddPtr = oddPtr.next
            evenPtr.next = oddPtr.next if oddPtr else None
            evenPtr = evenPtr.next
        if oddPtr: oddPtr.next = evenHead
        return head