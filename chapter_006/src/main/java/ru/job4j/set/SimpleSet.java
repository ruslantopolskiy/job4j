package ru.job4j.set;

        import ru.job4j.list.DynamicMassive;

        import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private DynamicMassive dynamicMassive;

    public SimpleSet() {
        this.dynamicMassive = new DynamicMassive();
    }

    public void add(T value) {
        dynamicMassive.add(value);
    }

    @Override
    public Iterator<T> iterator() {
        return dynamicMassive.iterator();
    }
}
