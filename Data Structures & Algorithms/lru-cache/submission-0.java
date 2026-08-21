

// Doubly Linked List Node to store key-value pairs
class Node {
    int key;
    int val;
    Node prev;
    Node next;

    // Default constructor (used for dummy head and tail nodes)
    Node() {}

    // Parameterized constructor to create new data nodes
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    // Map provides O(1) lookup to find nodes directly in memory by key
    private Map<Integer, Node> map;
    
    // Maximum capacity allowed in the cache
    private int cap;
    
    // Sentinel (dummy) nodes to avoid null checks for edge cases (empty list, head/tail updates)
    private Node head; // Head.next always points to the Most Recently Used (MRU) node
    private Node tail; // Tail.prev always points to the Least Recently Used (LRU) node

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail nodes
        head = new Node();
        tail = new Node();
        
        // Connect head and tail initially (representing an empty list)
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Helper method to disconnect an existing node from the doubly linked list.
     * Runs in O(1) time.
     */
    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        // Bypass 'node' by connecting its previous and next neighbors directly
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /**
     * Helper method to insert a node immediately after the dummy head.
     * This marks the node as the Most Recently Used (MRU).
     * Runs in O(1) time.
     */
    private void insertAfterHead(Node node) {
        Node nextNode = head.next;
        
        // Link head to the new node
        head.next = node;
        
        // Link the old first node back to the new node
        nextNode.prev = node;
        
        // Set the new node's pointers
        node.prev = head;
        node.next = nextNode;
    }

    /**
     * Retrieves the value for a key if it exists, and moves it to MRU position.
     * Runs in O(1) time.
     */
    public int get(int key) {
        // Step 1: If key doesn't exist, return -1
        if (!map.containsKey(key)) {
            return -1;
        }

        // Step 2: Fetch node from Map
        Node node = map.get(key);
        int val = node.val;

        // Step 3: Move node to the head (marking it as Most Recently Used)
        deleteNode(node);
        insertAfterHead(node);

        return val;
    }

    /**
     * Inserts or updates a key-value pair. Evicts the LRU node if over capacity.
     * Runs in O(1) time.
     */
    public void put(int key, int value) {
        // Case 1: Key already exists -> update value and refresh its position to MRU
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value; // Update value
            deleteNode(node); // Detach from current position
            insertAfterHead(node); // Insert right after head
            return;
        }

        // Case 2: Cache is full -> evict Least Recently Used (LRU) node before adding new one
        if (map.size() == cap) {
            Node lruNode = tail.prev; // Node right before tail is the LRU node
            map.remove(lruNode.key); // Remove from HashMap using the key stored in the node
            deleteNode(lruNode);     // Detach from doubly linked list
        }

        // Case 3: Insert new key-value node as Most Recently Used (MRU)
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
    }
}