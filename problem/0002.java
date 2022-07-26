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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // // method 1, loop to iterate, time = O(N), space = O(N)
        // ListNode head = new ListNode(), p = head;
        // int carry = 0;
        // while (l1 != null || l2 != null) {
        //     int v1 = (l1 != null) ? l1.val : 0;
        //     int v2 = (l2 != null) ? l2.val : 0;
        //     ListNode node = new ListNode();
        //     node.val = v1 + v2 + carry;                
        //     carry = (node.val > 9) ? 1 : 0;
        //     node.val %= 10;
        //     p.next = node;
        //     p = p.next;
        //     if (l1 != null) l1 = l1.next;
        //     if (l2 != null) l2 = l2.next;
        // }
        // if (carry == 1) p.next = new ListNode(1);
        // return head.next;
        
        // method 2, recursive, time = O(N), space = O(N)
        return addNode(l1, l2, 0);
    }
    
    private ListNode addNode(ListNode n1, ListNode n2, int carry) {
        if (n1 == null && n2 == null) 
            return (carry == 1) ? new ListNode(1) : null;
        int v1 = (n1 != null) ? n1.val : 0;
        int v2 = (n2 != null) ? n2.val : 0;        
        ListNode node = new ListNode(v1 + v2 + carry);
        carry = (node.val > 9) ? 1 : 0;
        node.val %= 10;
        node.next = addNode(
            n1 != null ? n1.next : null, 
            n2 != null ? n2.next : null,
            carry
        );
        return node;
    }
}