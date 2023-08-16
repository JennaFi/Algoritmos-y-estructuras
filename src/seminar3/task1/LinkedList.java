package seminar3.task1;

public class LinkedList {
    public Node head;

    public void addFirst(int value) {
        Node node = new Node(value);

//        TODO
        if (head == null) {
            node.next = head;
        } else {

            head = node;
        }

    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }
    public class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value =value;

            this.next = null;
        }
    }


}


