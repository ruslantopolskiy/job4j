package ru.job4j.tracker;

import ru.job4j.tracker.*;

public class StartUI {


    private static final String ADD = "0";
    private static final String REPLACE = "1";
    private static final String DELETE = "2";
    private static final String FINDALL = "3";
    private static final String FINDBYNAME = "4";
    private static final String FINDBYID = "5";
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDALL.equals(answer)) {
                this.findAllItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findbyName();
            } else if (FINDBYID.equals(answer)) {
                this.findbyId();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавление заявок");
        System.out.println("1. Редактирование заявок");
        System.out.println("2. Удаление заявок ");
        System.out.println("3. Получение списка всех заявок");
        System.out.println("4. Получение списка по имени");
        System.out.println("5. Получение заявки по id");
        System.out.println("6. Выход");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(id, name, desc);
        this.tracker.replace(item.getId(), item);
        System.out.println("------------ Заявка отредактирована : " + item.getName() + "-----------");
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = new Item(id);
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует получение списка всех заявок.
     */
    private void findAllItem() {
        System.out.println("------------ Получение списка всех заявок --------------");
        System.out.println("------------ Список всех заявок : " + this.tracker.findAll() + "-----------");
    }

    /**
     * Метод реализует получение списка по имени.
     */
    private void findbyName() {
        System.out.println("------------ Получение списка по имени --------------");
        String name = this.input.ask("Введите иля заявки :");
        System.out.println("------------ Cписок всех заявок по именем : " +this.tracker.findByName(name)  +"-----------");
    }

    /**
     * Метод реализует получение списка по id.
     */
    private void findbyId() {
        System.out.println("------------ Получение списка по id --------------");
        String id = this.input.ask("Введите id заявки :");
        System.out.println("------------ Cписок всех заявок : " + this.tracker.findById(id) + "-----------");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
