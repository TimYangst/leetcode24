package P146LRUCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    int capacity;

    Map<Integer, ListNode> cache;

    ListNode head;
    ListNode tail;

    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode previous;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.previous = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode current = cache.get(key);
        moveToHead(current);
        return current.val;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() == capacity) {
                removeLast();
            }
            ListNode current = new ListNode();
            current.val = value;
            current.key = key;
            cache.put(key, current);
            insertToHead(current);
        } else {
            ListNode current = cache.get(key);
            current.val = value;
            moveToHead(current);
        }
    }

    void moveToHead(ListNode current) {
        if (head.next != current) {
            ListNode n = current.next;
            ListNode p = current.previous;
            p.next = n;
            n.previous = p;
            insertToHead(current);
        }
    }

    void insertToHead(ListNode current) {
        current.next = head.next;
        current.next.previous = current;
        current.previous = head;
        head.next = current;
    }

    void removeLast() {
        ListNode toRemove = tail.previous;
        toRemove.previous.next = tail;
        tail.previous = toRemove.previous;
        cache.remove(toRemove.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
