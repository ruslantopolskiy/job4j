package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 */
public class DynamicMassive<T> implements Iterable<T> {
    private Object[] container;
    private int count;
    private int modCount;
    private int defaultIndex = 10;
    private int countIterator;


    public DynamicMassive() {
        this.container = new Object[defaultIndex];
    }

    public void installsizeContainer(int size) {
        if (size == 0) {
            this.container = new Object[defaultIndex];
        } else if (size > 0) {
            this.container = new Object[size];
        } else {
            throw new IllegalArgumentException("a negative number");
        }
    }

    public int getSize() {
        return container.length;
    }

    public void add(T value) {
        if (count >= container.length) {
            int newContainer = this.container.length + (this.container.length >> 1);
            this.container = Arrays.copyOf(this.container, newContainer);
        }
        this.container[count++] = value;
        modCount++;
    }

    public T get(int index) {
        if (index < 0 || index > this.container.length - 1) {
            throw new IndexOutOfBoundsException(String.format("Index %s size %s", index, this.count));
        } else {
            return (T) this.container[index];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;

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
                return (T) container[countIterator++];
            }
        };
    }
}