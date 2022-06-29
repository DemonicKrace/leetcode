class Trie {
    class TrieNode {
        
        final int ALPHA_SIZE = 26;

        private TrieNode[] links;
        
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[ALPHA_SIZE];
        }
        
        public TrieNode get(char c) {
            return links[c - 'a'];
        }
        
        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.get(c) == null) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            node = node.get(c);
            if (node == null) return null; 
        }
        return node;
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */