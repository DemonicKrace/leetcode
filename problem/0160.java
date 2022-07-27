/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // method 1, shift node diffs length, time = O(N), space = O(1)
        ListNode aPtr = headA, bPtr = headB;
        int aLen = 0, bLen = 0;
        while (aPtr != null || bPtr != null) {
            if (aPtr != null) {
                aPtr = aPtr.next;
                aLen++;
            }
            if (bPtr != null) {
                bPtr = bPtr.next;
                bLen++;
            }            
        }
        aPtr = headA; 
        bPtr = headB;
        int aShift = aLen - bLen, bShift = bLen - aLen;
        while (aShift-- > 0) aPtr = aPtr.next;
        while (bShift-- > 0) bPtr = bPtr.next;
        while (aPtr != null || bPtr != null) {
            if (aPtr == bPtr) return aPtr;
            aPtr = aPtr.next;
            bPtr = bPtr.next;
        }
        return null;
    }
}