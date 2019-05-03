package ru.job4j.jbdc;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
public class TrackerSQLTest {

        @Test
        public void checkConnection() {
            TrackerSQL sql = new TrackerSQL();
            assertThat(sql.init(), is(true));
        }

    @Test
    public void createItem() {
        TrackerSQL tracker = new TrackerSQL();
        tracker.add(new Item("name", "desc"));
        assertThat(tracker.findByName("name").size(), is(1));
    }

    }
