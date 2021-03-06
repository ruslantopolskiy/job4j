package ru.job4j.set;

import ru.job4j.list.DynamicMassive;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private DynamicMassive dynamicMassive;
    private int size;

    public SimpleSet() {
        this.dynamicMassive = new DynamicMassive();
    }

    public void add(T value) {
        if (uniqueValue(value)) {
            dynamicMassive.add(value);
        }
    }

    public int sizeMassive() {
        this.size = dynamicMassive.getSize();
        return this.size;
    }

    public boolean uniqueValue(T value) {
        boolean result = true;
        for (int index = 0; index < dynamicMassive.getSize(); index++) {
            if (dynamicMassive.get(index) != null && dynamicMassive.get(index).equals(value)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return dynamicMassive.iterator();
    }
}
