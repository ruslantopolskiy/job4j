/*
В этом задании необходимо сделать универсальную обертку над массивом.

        Создать класс:

public class SimpleArray<T>

Добавить методы:

        add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;

        set(int index, T model) - заменяет указанным элементом (model) элемент, находящийся по индексу index;

        remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);

        get(int index) - возвращает элемент, расположенный по указанному индексу;

        Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор, предназначенный для обхода данной структуры.

        Объект должен принимать количество ячеек. Структура не должна быть динамической. Если идет переполнение надо выкинуть ошибку.

*/

package ru.job4j.generic;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int count = 0;
    private int index = 0;

    public SimpleArray(Integer size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        if (index < this.index) {
            this.objects[index] = model;
        }
    }
    public void remove(int index) {
        if (index < this.index) {
            System.arraycopy(objects, index + 1, objects, index, objects.length - 1 - index);
            objects[objects.length - 1] = null;
        }
    }

    public T get(int index) {
        return (T) this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return count < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[count++];
            }
        };
    }
}
