package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput (final Input input){
        this.input = input;
    }

    @Override
    public String ask(String questions) {
        return this.input.ask(questions);
    }

    @Override
    public int ask(String questions, int[] ranges) {
       boolean invalid = true;
       int value = -1;
        do {
            try {
                value = this.input.ask(questions, ranges);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }catch (MenuOutException moe){
                    System.out.println("Please select key from menu.");
                }
        }
        while (invalid);
            return value;
    }
}
