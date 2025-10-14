import java.util.HashMap;

public class CustomCache<K, V> {
    private final int CAPACITY = 2000;
    private HashMap<K, Node> map = new HashMap<>();
    private Node head = null;
    private Node tail = null;

    private class Node {
        K key;
        V value;
        Node prev, next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Retrieve value and move node to head (most recently used)
    public V get(K key) {
        if (!map.containsKey(key)) return null;

        Node node = map.get(key);

        // Move to head
        if (node != head) {
            // Remove node from current position
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            if (node == tail) tail = node.prev;

            // Place node at head
            node.prev = null;
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
        }

        return node.value;
    }

    // Insert or update cache and manage eviction
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            get(key); // move to head
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);

            // Add to head
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;

            if (tail == null) tail = newNode;

            // Evict if over capacity
            if (map.size() > CAPACITY) {
                map.remove(tail.key);
                tail = tail.prev;
                if (tail != null) tail.next = null;
            }
        }
    }

    // For testing
    public static void main(String[] args) {
        CustomCache<Integer, String> cache = new CustomCache<>();
        for (int i = 1; i <= 2005; i++) {
            cache.put(i, "Value" + i);
        }

        System.out.println("Cache size after inserting 2005 elements: " + cache.map.size());
        System.out.println("Get key 2000: " + cache.get(2000));
        System.out.println("Get key 1 (should be evicted): " + cache.get(1));
    }
}
