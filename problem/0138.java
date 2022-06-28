/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        // next or random is point to null
        map.put(null, null);
        Node oldHead = head;
        while (oldHead != null) {
            // init old node map to new node 
            if (!map.containsKey(oldHead)) map.put(oldHead, new Node(0));
            if (!map.containsKey(oldHead.next)) map.put(oldHead.next, new Node(0));
            if (!map.containsKey(oldHead.random)) map.put(oldHead.random, new Node(0));
            // link new node 
            map.get(oldHead).val = oldHead.val;
            map.get(oldHead).next = map.get(oldHead.next);
            map.get(oldHead).random = map.get(oldHead.random);
            // iterate next node
            oldHead = oldHead.next;
        }
        return map.get(head);
    }
}