package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StubInputTest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
      //  Item item = tracker.add(new Item("test name", "desc"));
        Item item = new Item("test name","desc");
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"1", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeleteValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[1];
        result[0] = item1;
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenFindAllThenTrackerHasFindAllValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc"));
        Item item3 = tracker.add(new Item("test name3", "desc"));
        Item item4 = tracker.add(new Item("test name4", "desc"));
        Input input = new StubInput(new String[]{"3", "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[4];
        result[0] = item1;
        result[1] = item2;
        result[2] = item3;
        result[3] = item4;
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenFindNameThenTrackerHasFindNameValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc"));
        Item item3 = tracker.add(new Item("test name2", "desc"));
        Item item4 = tracker.add(new Item("test name2", "desc"));
        Item item5 = tracker.add(new Item("test name5", "desc"));
        Input input = new StubInput(new String[]{"4",item2.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[3];
        result[0] = item2;
        result[1] = item3;
        result[2] = item4;
        assertThat(tracker.findByName(item2.getName()), is(result));
    }

    @Test
    public void whenFindIDThenTrackerHasFindIDValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc"));
        Item item3 = tracker.add(new Item("test name3", "desc"));
        Item item4 = tracker.add(new Item("test name4", "desc"));
        Input input = new StubInput(new String[]{"5",item2.getId(), "6"});
        new StartUI(input, tracker).init();
/*        Item[] result = new Item[1];
        result[0] = item2;
        result[1] = item3;
        result[2] = item4;*/
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
}

