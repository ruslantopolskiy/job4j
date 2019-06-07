package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private final Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
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
            output.accept("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String description = input.ask("Please, provide item description:");
            Item item = new Item(name, description);
            tracker.add(item);
            output.accept("------------ New Item with Id : " + item.getId());
            output.accept("------------ New Item with Name : " + item.getName());
            output.accept("------------ New Item with Description : " + item.getDescription());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Show item's --------------");
            for (Item item : tracker.findAll()) {
                output.accept((String.format("Id: %s Name: %s Description: %s",
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
            output.accept("------------ Edit item --------------");
            String id = input.ask("Please, provide item id:");
            String name = input.ask("Please, provide item name:");
            String description = input.ask("Please, provide item description:");
            Item item = new Item(name, description);
            tracker.replace(id, item);
            output.accept((String.format("Id: %s Name: %s Description: %s",
                    item.getId(), item.getName(), item.getDescription())));
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Delete item --------------");
            String id = input.ask("Please, provide item id: ");
            boolean result = tracker.delete(id);
            if (result) {
                output.accept("Item was deleted");
            } else {
                output.accept(String.format("Item no was deleted id %s", id));
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
            Item result = tracker.findById(id);
            if (result != null) {
                output.accept(String.format("Item was id: %s", id));
            } else {
                output.accept(String.format("Item no was id: %s", id));
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
            ArrayList<Item> result = tracker.findByName(name);
            if (result.size() > 0) {
                for (Item item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println(String.format("Item no was name: %s", name));
            }
        }
    }
}

