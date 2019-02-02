package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicMassiveTest {
    private DynamicMassive<Integer> list;


    @Before
    public void beforeTest() {
        this.list = new DynamicMassive<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
    }

    @Test
    public void WhenGetElementThen() {
        assertThat(list.get(3), is(5));
    }

    @Test
    public void WhenAddElements() {
        list.add(33);
        assertThat(list.getSize(), is(10));
        list.add(11);
        assertThat(list.getSize(), is(15));
    }

    @Test
    public void WhenGetSize() {
        list.installsizeContainer(10);
        assertThat(list.getSize(), is(10));
    }

    @Test (expected = IndexOutOfBoundsException .class)
    public void WhenIndexOutBoundsException (){
        assertThat(list.get(8),is(8));
        list.get(10);
    }

    @Test
    public void WhenNextIterator(){
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext(),is(true));
        assertThat(iterator.hasNext(),is(true));
        assertThat(iterator.next(),is(0));
        assertThat(iterator.next(),is(1));
        assertThat(list.iterator().next(),is(0));

    }

    @Test()
    public void WhenAdd2(){
        list.iterator().next();
        list.add(3432);
        list.iterator().next();

    }

}