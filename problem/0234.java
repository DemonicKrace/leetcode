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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = split(head);
        ListNode rHead = reverse(mid);
        while (head != null && rHead != null) {
            if (head.val != rHead.val) return false;
            head = head.next;
            rHead = rHead.next;
        }
        return true;
    }
    
    private ListNode split(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }
        if (slow != null) {
            ListNode mid = slow.next;
            slow.next = null;
            return mid;
        } 
        return head;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        return prev;
    }
}