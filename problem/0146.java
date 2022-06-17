class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode post;
    }
    DLinkedNode head;
    DLinkedNode tail;
    int count;
    int size;
    Map<Integer, DLinkedNode> cache;
    
    public LRUCache(int capacity) {
        count = 0;
        size = capacity;
        cache = new HashMap();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.post = tail;
        tail.prev = head;        
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;        
        // move node behind head
        moveToHead(node);        
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {            
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addToHead(newNode);
            cache.put(key, newNode);
            count++;        
            if (count > size) {
                cache.remove(tail.prev.key);
                removeTail();
                count--;
            }
        } else {
            node.value = value;
            moveToHead(node);            
        }        
    }
    
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.post = head.post;
        head.post.prev = node;
        head.post = node;
    }
    
    private void moveToHead(DLinkedNode node) {
        node.prev.post = node.post;
        node.post.prev = node.prev;
        node.post = head.post;
        node.prev = head;
        head.post.prev = node;
        head.post = node;
    }
    
    private void removeTail() {
        DLinkedNode targetNode = tail.prev;
        DLinkedNode prevTarget = targetNode.prev;
        prevTarget.post = tail;
        tail.prev = prevTarget;
        targetNode.prev = null;
        targetNode.post = null;        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */