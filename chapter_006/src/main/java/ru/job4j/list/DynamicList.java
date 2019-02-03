package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<T> implements Iterable<T> {
    private int modCount;
    private int count;
    private Note<T> head;
    private Note<T> teal;

    public int size() {
        return this.count;
    }

    public void add(T date) {
        Note<T> note = new Note<>(date);
        if (head == null) {
            this.head = note;
            count++;
        }else if (teal == null){
            this.teal = note;
            this.head.next = teal;
            count++;
        } else {
            teal.next = note;
            this.teal =note;
            count++;
        }
    }

    public T get(int in) {
        Note<T> result = head;
        for (int index = 0; index < in; index++) {
            result = result.next;
        }
        return result.date;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
           private int expectedModCount = modCount;
           private int countIterator;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return countIterator < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = head.date;
                head = head.next;
                return result;
            }
        };
    }

    private static class Note<T> {
        T date;
        Note<T> next;

        public Note(T date) {
            this.date = date;
        }
    }
}
