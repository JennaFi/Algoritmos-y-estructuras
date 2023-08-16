package seminar3.task5;

import seminar3.task3.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(5);
        System.out.println(list);
        list.addLast(5);
        list.addLast(4);
        System.out.println(list);

    }
}
