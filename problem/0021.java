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

    // method 1, recursive, time = O(N), space = O(N)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return l2 == null ? l1 : l2;
        ListNode first = (l2.val < l1.val) ? l2 : l1;
        first.next = mergeTwoLists(first.next, first == l1 ? l2 : l1);
        return first;
    }

    // method 2, recursive, time = O(N), space = O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode head = temp, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if (p1 != null) temp.next = p1;
        if (p2 != null) temp.next = p2;
        return head.next;
    }
}