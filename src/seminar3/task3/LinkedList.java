package seminar3.task3;

public class LinkedList {

    private Node head;


    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {//список пуст
            head = node;
        } else { //список наполнен
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void deleteLast() {
        if (head != null) {
            Node current = head;
            while (current.next != null) {//todo проверка на последний =null
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                current = current.next;
            }
            head = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = head;
        str.append(current.value);
        while (current.next != null){
            str.append(current.value).append(" , ");
            current = current.next;
        }

        return "LinkedList{" +
                str +
                '}';
    }

    public static class Node {

        public int value;

        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
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
