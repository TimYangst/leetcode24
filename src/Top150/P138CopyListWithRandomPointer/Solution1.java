package Top150.P138CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

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

class Solution1 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node result = new Node(head.val);
        Node rp = result;
        Map<Node, Node> orignalMapping = new HashMap<>();
        orignalMapping.put(head, result);
        Node current = head;
        while (current.next != null) {
            current = current.next;
            Node newNode = new Node(current.val);
            orignalMapping.put(current, newNode);
            rp.next = newNode;
            rp = newNode;
        }
        current = head;
        while (current != null) {
            if (current.random != null) {
                orignalMapping.get(current).random = orignalMapping.get(current.random);
            }
            current = current.next;
        }
        return result;
    }
}