package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;

public class MenuTracker {
    private Input input;
    private Tracker tracker;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private List<UserAction> actions = new ArrayList<>();

    public void fillActions() {
        actions.add(0, new AddItem(0, "Add new Item."));
        actions.add(1, new ShowItems(1, "Show Item's."));
        actions.add(2, new EditItems(2, "Edit Item."));
        actions.add(3, new DeleteItem(3, "Delete Item."));
        actions.add(4, new FindbyIdItem(4, "Find by Id Item."));
        actions.add(5, new FindbyNameItem(5, "Find by Name Item."));
    }

    public int getSizeActions() {
        return actions.size();
    }

    public void select(int key) {
        actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction userAction : actions) {
            if (userAction != null) {
                System.out.println(userAction.info());
            }
        }
    }

    public int[] getMassives() {
        int[] massive = new int[actions.size()];
        for (int index = 0; index < actions.size(); index++) {
            massive[index] = index;
        }
        return massive;
    }

    abstract class BaseAction implements UserAction {

        private int key;
        private String name;

        BaseAction(final int key, final String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.name);
        }
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String description = input.ask("Please, provide item description:");
            Item item = new Item(name, description);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Show item's --------------");
            for (Item item : tracker.findAll()) {
                System.out.println((String.format("Id: %s Name: %s Description: %s",
                        item.getId(), item.getName(), item.getDescription())));
            }
        }
    }

    private class EditItems extends BaseAction {

        public EditItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Edit item --------------");
            String id = input.ask("Please, provide item id:");
            String name = input.ask("Please, provide item name:");
            String description = input.ask("Please, provide item description:");
            Item item = new Item(name, description);
            tracker.replace(id, item);
            System.out.println((String.format("Id: %s Name: %s Description: %s",
                    item.getId(), item.getName(), item.getDescription())));
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item --------------");
            String id = input.ask("Please, provide item id: ");
            boolean result = tracker.delete(id);
            if (result) {
                System.out.println("Item was deleted");
            } else {
                System.out.println(String.format("Item no was deleted id %s", id));
            }
        }
    }

    private class FindbyIdItem extends BaseAction {

        public FindbyIdItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, provide item id:");
            Item result = tracker.findbyId(id);
            if (result != null) {
                System.out.println(String.format("Item was id: %s", id));
            } else {
                System.out.println(String.format("Item no was id: %s", id));
            }
        }
    }


    private class FindbyNameItem extends BaseAction {

        public FindbyNameItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, provide item name: ");
            Item[] result = tracker.findByName(name);
            if (result.length > 0) {
                for (Item item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println(String.format("Item no was name: %s", name));
            }
        }
    }
}

