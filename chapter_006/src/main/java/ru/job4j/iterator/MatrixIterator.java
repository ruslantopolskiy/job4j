package ru.job4j.iterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MatrixIterator implements Iterator {

    private final int[][] array;
    private int x, y = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array[x].length != y;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return array[x][y++];
        } else {
            y = 0;
            return array[++x][y++];
        }
    }
}

