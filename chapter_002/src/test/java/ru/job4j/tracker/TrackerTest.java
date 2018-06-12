package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    /**
     * tracker.add
     */

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * tracker.replace
     */

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("Вася", "020", 1);
        tracker.add(previous);
        Item next = new Item("Петр", "d12", 2);
        tracker.add(next);
        next.setId(previous.getId());
        tracker.replace(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("Петр"));
    }

    /**
     * tracker.delete
     */

    @Test
    public void whenDeleteItemThenReturnNewTracker() {
        Tracker tracker = new Tracker();
        Item one = new Item("Вася", "testDescription", 1);
        tracker.add(one);
        Item two = new Item("Петя", "testDescription", 2);
        tracker.add(two);
        Item three = new Item("Давид", "testDescription", 3);
        tracker.add(three);
        tracker.delete(two.getId());
        Item[] result = new Item[2];
        result[0] = one;
        result[1] = three;
        assertThat(tracker.findAll(), is(result));
    }

    /**
     * tracker.findByName
     */

    @Test
    public void whenFindByNameThenReturnByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("Петр", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("Иван", "testDescription2", 234L);
        tracker.add(second);
        Item third = new Item("Петр", "testDescription3", 456L);
        tracker.add(third);
        Item fo = new Item("Петр", "testDescription3", 456L);
        tracker.add(fo);
        Item[] expected = new Item[3];
        expected[0] = first;
        expected[1] = third;
        expected[2] = fo;
        assertThat(tracker.findByName("Петр"), is(expected));
    }

    /**
     * tracker.findById
     */

    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("Петр", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("Иван", "testDescription2", 234L);
        tracker.add(second);
        Item third = new Item("Петр", "testDescription3", 456L);
        tracker.add(third);
        String id = second.getId();
        assertThat(tracker.findById(id), is(second));
    }

    /**
     * tracker.findAll
     */

    @Test
    public void whenFindByALLThenReturn() {
        Tracker tracker = new Tracker();
        Item a = new Item("Петр2", "testDescription1", 123L);
        tracker.add(a);
        Item b = new Item("Иван", "testDescription2", 234L);
        tracker.add(b);
        Item c = new Item("Петр", "testDescription3", 456L);
        tracker.add(c);
        Item[] result = new Item[3];
        result[0] = a;
        result[1] = b;
        result[2] = c;
        assertThat(tracker.findAll(), is(result));
    }

}