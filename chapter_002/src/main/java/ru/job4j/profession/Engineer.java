package ru.job4j.profession;

public class Engineer extends Profession {
    public Build build(House house) {
        return new Build();
    }
}
