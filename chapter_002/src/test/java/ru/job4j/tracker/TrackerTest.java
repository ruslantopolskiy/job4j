package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    /**
     * tracker.add
     */

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * tracker.replace
     */

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("Вася", "020");
        tracker.add(previous);
        Item next = new Item("Петр", "d12");
        tracker.add(next);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findbyId(previous.getId()).getName(), is("Петр"));
    }

    /**
     * tracker.delete
     */

    @Test
    public void whenDeleteItemThenReturnNewTracker() {
        Tracker tracker = new Tracker();
        Item one = new Item("Вася", "testDescription");
        tracker.add(one);
        Item two = new Item("Петя", "testDescription");
        tracker.add(two);
        Item three = new Item("Давид", "testDescription");
        tracker.add(three);
        tracker.delete(one.getId());
        List<Item> result = new ArrayList<>();
        result.add(two);
        result.add(three);
        assertThat(tracker.findAll(), is(result));
    }

    /**
     * tracker.findByName
     */

    @Test
    public void whenFindByNameThenReturnByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("Петр", "testDescription1");
        tracker.add(first);
        Item second = new Item("Иван", "testDescription2");
        tracker.add(second);
        Item third = new Item("Петр", "testDescription3");
        tracker.add(third);
        Item fo = new Item("Петр", "testDescription3");
        tracker.add(fo);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(first);
        expected.add(third);
        expected.add(fo);
        assertThat(tracker.findByName("Петр"), is(expected));
    }

    /**
     * tracker.findById
     */

    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("Петр", "testDescription1");
        tracker.add(first);
        Item second = new Item("Иван", "testDescription2");
        tracker.add(second);
        Item third = new Item("Петр", "testDescription3");
        tracker.add(third);
        String id = second.getId();
        assertThat(tracker.findbyId(id), is(second));
    }

    /**
     * tracker.findAll
     */

    @Test
    public void whenFindByALLThenReturn() {
        Tracker tracker = new Tracker();
        Item a = new Item("Петр2", "testDescription1");
        tracker.add(a);
        Item b = new Item("Иван", "testDescription2");
        tracker.add(b);
        Item c = new Item("Петр", "testDescription3");
        tracker.add(c);
        ArrayList<Item> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        assertThat(tracker.findAll(), is(result));
    }

}