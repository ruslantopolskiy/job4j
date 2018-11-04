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
        actions.add(0, new AddItem());
        actions.add(1, new ShowItems());
        actions.add(2, new EditItems());
        actions.add(3,new DeleteItem());
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

    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return "Add new Item.";
        }
    }

    private class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Show item's --------------");
            for (Item item : tracker.findAll()){
                System.out.println((String.format("Id: %s Name: %s Description: %s",
                        item.getId(), item.getName(), item.getDescription())));
        }}

        @Override
        public String info() {
            return "Show Item's.";
        }
    }

    private class EditItems implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "Edit Item.";
        }
    }

    public class DeleteItem implements UserAction{
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return "Delete Item";
        }
    }

}
