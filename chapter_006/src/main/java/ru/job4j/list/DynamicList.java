package ru.job4j.list;

import java.util.Iterator;

public class DynamicList<T> implements Iterable<T> {



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }
            @Override
            public T next() {
                return null;
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
