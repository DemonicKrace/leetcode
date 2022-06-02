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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        // get first node
        ListNode first = (l1.val < l2.val) ? l1 : l2;
        // merge next part
        first.next = merge(first.next, first == l1 ? l2 : l1);
        return first;
    }

    ListNode getMid(ListNode head) {
        ListNode preMid = null;
        ListNode end = head;
        while (end != null && end.next != null) {
            preMid = (preMid == null) ? head : preMid.next;
            end = end.next.next;
        }
        ListNode mid = preMid.next;
        // split in two list
        preMid.next = null;
        return mid;
    }
}
