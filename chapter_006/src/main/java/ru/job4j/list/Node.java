package ru.job4j.list;


public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node start) {
        Node firstOne = start;
        Node secondOne = start;
        if (start == null) {
            throw new IndexOutOfBoundsException("no elements");
        }

        boolean result = false;
        while (secondOne.next != null && secondOne.next.next != null) {
            firstOne = firstOne.next;
            secondOne = secondOne.next.next;
            if (firstOne == secondOne) {
                result = true;
                break;
            }
        }

        return result;
    }


}
