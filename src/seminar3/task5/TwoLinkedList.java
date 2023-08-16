package seminar3.task5;

public class TwoLinkedList {

    private Node head;

    private Node tail;


    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null && head.previous != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (tail == null) {//список пуст
            tail = node;
        } else { //список наполнен
            Node current = tail;
            tail.next = node;
            node.previous = current;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            head = null;
            tail = null;
        }
    }

    private class Node {

        private int value;

        private Node next;

        private Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public boolean isContains(int target) {
        return find(target) != null ? true : false;
    }

    public Node find(int target) {
        while (head != null) {
            if (head.value == target) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}