import java.util.HashMap;

public class LRU_Cache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
private HashMap<Integer, Node> map;
    private Node head;  
    private Node tail;
    private int capacity;   

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; 
        }
       Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = head;
        node.next = head.next;  
        head.next.prev = node;
        head.next = node;

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; 
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = head;
            node.next = head.next;  
            head.next.prev = node;
            head.next = node;
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev; 
                lru.prev.next = tail;
                tail.prev = lru.prev;
                map.remove(lru.key); 
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            newNode.prev = head;
            newNode.next = head.next;  
            head.next.prev = newNode;
            head.next = newNode;
        }
    }

    public void display() {
        Node current = head.next;
        while (current != tail) {
            System.out.print("[" + current.key + ":" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
       LRU_Cache cache = new LRU_Cache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.display(); 

        System.out.println("Get key 2: " + cache.get(2)); 
        cache.display(); 

        cache.put(4, 40); 
        cache.display(); 

        System.out.println("Get key 1: " + cache.get(1)); 
        cache.display();
        cache.put(5, 50);
        cache.display();
    }
}