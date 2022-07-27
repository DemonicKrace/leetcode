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
    public ListNode oddEvenList(ListNode head) {
        // method 1, loop to iterate, time = O(N), space = O(1)
        ListNode evenHead = (head == null) ? null : head.next;
        ListNode oddPtr = head, evenPtr = evenHead;
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
        }
        if (oddPtr != null) oddPtr.next = evenHead;
        return head;
    }
}