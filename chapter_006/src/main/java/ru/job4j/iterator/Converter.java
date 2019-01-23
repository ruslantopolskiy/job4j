package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            Iterator<Integer> inner = it.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (it.hasNext() || inner.hasNext()){
                if (inner.hasNext()) {
                    result = true;
                    break;
                } else  {
                    inner = it.next();
                }}
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inner.next();
            }
        };

    }
}
