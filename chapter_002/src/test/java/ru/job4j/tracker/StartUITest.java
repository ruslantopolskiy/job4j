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
            .append("Меню :")
            .append(System.lineSeparator())
            .append("0. Добавить заявку.")
            .append(System.lineSeparator())
            .append("1. Заменить заявку.")
            .append(System.lineSeparator())
            .append("2. Удалить заявку.")
            .append(System.lineSeparator())
            .append("3. Показать все заявки")
            .append(System.lineSeparator())
            .append("4. Найти заявку по имени")
            .append(System.lineSeparator())
            .append("5. Найти заявка по id.")
            .append(System.lineSeparator())
            .append("6. Выход.")
            .append(System.lineSeparator())
            .append(System.lineSeparator());

    /**
     * tracker.add
     */
    @Test
    public void whenUserAddItemThenTrackerHasName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("-----Добавление новой заявки-----")
                                .append(System.lineSeparator())
                                .append("Заявка с id " + tracker.findByName("test name")[0].getId() + " создана!")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenUserReplaceItemThenTrackerHasReplace() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", item.getId(), "test name1", "desc1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("-----Редактирование заявки-----")
                                .append(System.lineSeparator())
                                .append("Заявка с id " + item.getId() + " заменена!")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasDelete() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "n1"));
        Item item1 = tracker.add(new Item("test2", "n2"));
        Input input = new StubInput(new String[]{"2", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[1];
        result[0] = item;
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenUserFindAllItemThenTrackerHasFindAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desk1"));
        Item item1 = tracker.add(new Item("test2", "desk2"));
        Item item2 = tracker.add(new Item("test3", "desk3"));
        Input input = new StubInput(new String[]{"3", "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[3];
        result[0] = item;
        result[1] = item1;
        result[2] = item2;
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenUserFindByNameItemThenTrackerHasFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desk1"));
        Item item1 = tracker.add(new Item("test2", "desk2"));
        Item item2 = tracker.add(new Item("test1", "desk3"));
        Item item3 = tracker.add(new Item("test1", "desk4"));
        Input input = new StubInput(new String[]{"4", "test1", "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[3];
        result[0] = item;
        result[1] = item2;
        result[2] = item3;
        assertThat(tracker.findByName("test1"), is(result));
    }

    @Test
    public void whenUserFindByIdItemThenTrackerHasFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desk1"));
        Item item1 = tracker.add(new Item("test2", "desk2"));
        Input input = new StubInput(new String[]{"5", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findbyId(item.getId()), is(item));
    }


}