package ru.job4j.list;

/**
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        if (this.first == null) {
            this.first = newLink;
            size++;
        } else {
            newLink.next = this.first;
            this.first = newLink;
            size++;
        }
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        if (first == null) {
            throw new IllegalStateException("список элементов пустой");
        }
        Node<E> node = this.first;
        this.first = this.first.next;
        node.next  = null;
        return node.date;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "date=" + date +
                    ", next=" + next +
                    '}';
        }
    }
}