package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] array;
    private int x, y = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (x >= array.length) {
            return false;
        }
        return array[x].length > y;
    }


    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int res = array[x][y++];
        if (y == array[x].length) {
            y = 0;
            x++;
        }
        return res;
    }
}

