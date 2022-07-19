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

// 2022-07-19
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
        // single node
        if (head.next == null) return true;
        // find first part end
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // store second list start node, wait to reverse
        ListNode halfStart = slow.next;
        // split as two list
        slow.next = null;
        // reverse second list
        ListNode rHead = reverseListNode(halfStart);
        while (head != null && rHead != null) {
            // check first list and second list value is same
            if (head.val != rHead.val) return false;
            head = head.next;
            rHead = rHead.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}