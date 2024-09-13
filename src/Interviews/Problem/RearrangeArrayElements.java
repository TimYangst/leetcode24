package Interviews.Problem;

public class RearrangeArrayElements {

    class Node {
        int value;
        Node next = null;
        Node previous = null;

        public Node(int value) {
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node head = new Node(-1);
        Node tail = new Node(-1);
        int size = 0;

        public DoubleLinkedList() {
            head.next = tail;
            tail.previous = head;
        }

        public void append(int ele) {
            Node node = new Node(ele);
            node.next = tail;
            node.previous = tail.previous;
            tail.previous.next = node;
            tail.previous = node;
            size++;
        }

        public int[] toArray() {
            return new int[] {};
        }
    }

    private void rearrange(Node current, Node tail) {
        // TODO

    }

    public int[] rearrangeArray(int[] arr) {
        if (arr.length <= 2)
            return arr;
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        for (int ele : arr) {
            doubleLinkedList.append(ele);
        }
        int remains = arr.length;
        Node current = doubleLinkedList.head.next;
        while (remains > 2) {
            rearrange(current, doubleLinkedList.tail);
            current = current.next.next;
            remains -= 2;
        }
        return doubleLinkedList.toArray();
    }

}
