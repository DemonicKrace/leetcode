class MinStack {
    class DListNode {
        int val;
        int min;
        DListNode prev;
        DListNode next;
        DListNode(){}
        DListNode(int val, int min) {this.val = val; this.min = min;}
    }
    
    DListNode head, tail;
    
    public MinStack() {
        head = new DListNode();
        tail = head;
    }
    
    public void push(int val) {
        int preMin = (tail == head) ? val : getMin();
        DListNode node = new DListNode(val, Math.min(val, preMin));
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
    }
    
    public void pop() {
        tail.prev.next = null;
        DListNode prev = tail.prev;
        tail.prev = null;
        tail = prev;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        return tail.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */