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

    public void addLast(T date) {
        Note<T> note = new Note<>(date);
        if (head == null) {
            this.head = note;
            count++;
            modCount++;
        } else if (teal == null) {
            this.teal = note;
            this.head.next = teal;
            count++;
            modCount++;
        } else {
            teal.next = note;
            this.teal = note;
            count++;
            modCount++;
        }
    }

    public void addFirst(T date) {
        Note<T> note = new Note<>(date);
        note.next = this.head;
        this.head = note;
        count++;
        modCount++;
    }

    public T get(int in) {
        Note<T> result = head;
        for (int index = 0; index < in; index++) {
            result = result.next;
        }
        return result.date;
    }

    public T delete() {
        if (this.head == null) {
            throw new IllegalArgumentException("not elements");
        }

        Note<T> temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        count--;
        modCount++;
        return temp.date;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int countIterator;
            private Note<T> resultFinish = head;

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
                countIterator++;
                T resultIn = resultFinish.date;
                resultFinish = resultFinish.next;
                return resultIn;

            }
        };
    }

    private static class Note<T> {
        T date;
        Note<T> next;

        @Override
        public String toString() {
            return "Note{" + "date=" + date + ", next=" + next + '}';
        }

        public Note(T date) {
            this.date = date;
        }
    }
}
