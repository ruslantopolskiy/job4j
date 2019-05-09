package ru.job4j.list;

public class SimpleStack<T> {
    DynamicList<T> list = new DynamicList<>();

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.addFirst(value);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
