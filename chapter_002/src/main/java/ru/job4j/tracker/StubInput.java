package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String questions, int[] ranges) {
        //return Integer.valueOf(this.value[this.position++]);
        int key = Integer.valueOf(this.value[this.position++]);
        boolean exit = false;
        for (int value : ranges) {
            if (value == key) {
                exit = true;
                break;
            }
        }
        if (!exit) {
            throw new MenuOutException("Out of menu ranges");
        }
        return key;
    }
}
