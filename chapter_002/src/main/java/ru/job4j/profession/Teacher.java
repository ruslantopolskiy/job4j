package ru.job4j.profession;

public class Teacher extends Profession {
    public Teach teach(Student student) {
        return new Teach();
    }
}
