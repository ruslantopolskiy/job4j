package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class DynamicListTest {
    DynamicList<Integer> list;

    @Before
    public void before() {
        list = new DynamicList();
        list.addLast(2);
        list.addLast(3);
    }

    @Test
    public void WhenThen() {
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(3));
    }

    @Test
    public void When() {
        assertThat(list.size(), is(2));
    }

    @Test
    public void WhenT() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test()
    public void WhenAdd2() {
        list.iterator().next();
        list.addLast(3432);
        list.addLast(34323);
        list.iterator().next();
    }

    @Test
    public void name() {
        final Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        final Integer integer = list.get(0);
        assertThat(integer, is(2));

    }

}