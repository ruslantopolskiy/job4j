package ru.job4j.generic;

import java.util.NoSuchElementException;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleArrayTest {

    private SimpleArray<Integer> it;

    @Before
    public void setup() {
        it = new SimpleArray<Integer>(5);
        it.add(2);
        it.add(4);
        it.add(1);
        it.add(6);
        it.add(22);



    }

    @Test
    public void whenAddThreeElementsThenGetFirstElementResultFour () {
        assertThat(it.get(1), is(4));
        assertThat(it.get(3), is(6));
        it.set(3,000);
        assertThat(it.get(3),is(000));
        assertThat(it.get(2), is(1));
    }

    @Test
    public void whenAddThreeElements3 () {
        assertThat(it.iterator().next(),is(2));
        assertThat(it.iterator().hasNext(),is(true));
        assertThat(it.iterator().hasNext(),is(true));
        assertThat(it.iterator().next(),is(4));
        assertThat(it.iterator().next(),is(1));
        assertThat(it.iterator().hasNext(),is(true));
        assertThat(it.iterator().next(),is(6));
        assertThat(it.iterator().hasNext(),is(true));
        assertThat(it.iterator().next(),is(22));
        assertThat(it.iterator().hasNext(),is(false));

    }

    @Test (expected = NoSuchElementException.class)
    public void whenUseNextOutOFBoundsThenException() {
        it = new SimpleArray<>(0);
        it.iterator().next();


    }

}