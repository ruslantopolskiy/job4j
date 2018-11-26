package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    private final StringBuilder menu = new StringBuilder()
            .append("0. Add new Item.")
            .append(System.lineSeparator())
            .append("1. Show Item's.")
            .append(System.lineSeparator())
            .append("2. Edit Item.")
            .append(System.lineSeparator())
            .append("3. Delete Item.")
            .append(System.lineSeparator())
            .append("4. Find by Id Item.")
            .append(System.lineSeparator())
            .append("5. Find by Name Item.")
            .append(System.lineSeparator());


    /**
     * tracker.add
     */
    @Test
    public void whenUserAddItemThenTrackerHasName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc","y"});
        new StartUI(new ValidateInput(input),tracker).init();

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Adding new item --------------")
                                .append(System.lineSeparator())
                                .append("------------ New Item with Id : "+tracker.findByName("test name")[0].getId())
                                .append(System.lineSeparator())
                                .append("------------ New Item with Name : " +tracker.findByName("test name")[0].getName())
                                .append(System.lineSeparator())
                                .append("------------ New Item with Description : "+ tracker.findByName("test name")[0].getDescription())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserFindAllItemItemThenTrackerHasReplace() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(new ValidateInput (input),(tracker)).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Show item's --------------")
                                .append(System.lineSeparator())
                                .append("Id: " +item.getId()+ " Name: " + item.getName() + " Description: " + item.getDescription() )
                                .append(System.lineSeparator())
                                .append("Id: " +item1.getId()+ " Name: " + item1.getName() + " Description: " + item1.getDescription() )
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserReplaceItemThenTrackerHasFindAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desk1"));
        Input input = new StubInput(new String[]{"2",item.getId(),"test2","desk2","y"});
        new StartUI(new ValidateInput(input), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Edit item --------------")
                                .append(System.lineSeparator())
                                .append("Id: " +item.getId()+ " Name: " + tracker.findbyId(item.getId()).getName() + " Description: " + tracker.findbyId(item.getId()).getDescription())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }


    @Test
    public void whenUserDeleteItemThenTrackerHasDelete() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "n1"));
        Item item1 = tracker.add(new Item("test2", "n2"));
        Input input = new StubInput(new String[]{"3", item1.getId(), "y"});
        new StartUI(new ValidateInput(input), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Delete item --------------")
                                .append(System.lineSeparator())
                                .append("Item was deleted")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }



    @Test
    public void whenUserFindByNameItemThenTrackerHasFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desk1"));
        Item item1 = tracker.add(new Item("test2", "desk2"));
        Item item2 = tracker.add(new Item("test1", "desk3"));
        Item item3 = tracker.add(new Item("test1", "desk4"));

        Input input = new StubInput(new String[]{"5", "test1", "y"});
        new StartUI(new ValidateInput(input), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append(item)
                                .append(System.lineSeparator())
                                .append(item2)
                                .append(System.lineSeparator())
                                .append(item3)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserFindByIdItemThenTrackerHasFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desk1"));
        Item item1 = tracker.add(new Item("test2", "desk2"));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(new ValidateInput(input), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("Item was id: " +item.getId())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }


}