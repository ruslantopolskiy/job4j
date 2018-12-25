package ru.job4j.Comparable;

public class User implements Comparable <User> {
    private String name;
    private Integer age;

    public User (String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
