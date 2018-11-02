package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {

    private static final String ADD = "0";
    private static final String REPLACE = "1";
    private static final String DELETE = "2";
    private static final String FINDALL = "3";
    private static final String FINDBYNAME = "4";
    private static final String FINDBYID = "5";
    private static final String EXIT = "6";

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private void showMenu() {
        System.out.println("Меню :");
        System.out.println("0. Добавить заявку.");
        System.out.println("1. Заменить заявку.");
        System.out.println("2. Удалить заявку.");
        System.out.println("3. Показать все заявки");
        System.out.println("4. Найти заявку по имени");
        System.out.println("5. Найти заявка по id.");
        System.out.println("6. Выход.");
        System.out.println("");
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            String answer = input.ask("Выберите пунк меню: ");
            if (ADD.equals(answer)) {
                createItem();
            } else if (REPLACE.equals(answer)) {
                replaceItem();
            } else if (DELETE.equals(answer)) {
                deleteItem();
            } else if (FINDALL.equals(answer)) {
                findAllItem();
            } else if (FINDBYNAME.equals(answer)) {
                findNameItem();
            } else if (FINDBYID.equals(answer)) {
                findIdItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("-----Добавление новой заявки-----");
        String name = input.ask("Введите имя заявки");
        String desc = input.ask("Введите комментарий к заявке");
        Item item = tracker.add(new Item(name, desc));
        System.out.println("Заявка с id " + item.getId() + " создана!");
    }

    private void replaceItem() {
        System.out.println("-----Редактирование заявки-----");
        String id = input.ask("Введите id заявки");
        String name = input.ask("Введите имя заявки");
        String desc = input.ask("Введите комментарий к заявке");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
        System.out.println("Заявка с id " + item.getId() + " заменена!");
    }

    private void deleteItem() {
        System.out.println("-----Удаление заявки-----");
        String id = input.ask("Введите id заявки");
        tracker.delete(id);
        System.out.println("Заявка с id " + id + " удалена!");
    }

    private void findAllItem() {
        System.out.println("-----Все заявки-----");
        System.out.println(tracker.findAll());
    }

    private void findNameItem() {
        System.out.println("-----Поиск заявки по имени-----");
        String name = input.ask("Введите имя");
        Item[] byName = tracker.findByName(name);
        if (byName.length > 0) {
            for (Item item : byName) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявок с таким именем нет");
        }
    }

    private void findIdItem() {
        System.out.println("-----Поиск заявки по id-----");
        String id = input.ask("Введите id");
        Item byId = tracker.findbyId(id);
        if (byId != null) {
                System.out.println("Заявка с id " + byId.getId() + " найдена");
        } else {
            System.out.println("Заявок с таким id нет");
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }


}
