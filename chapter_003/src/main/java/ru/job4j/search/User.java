package ru.job4j.search;

public class User {
    private String name;
    private String id;
    private String city;

    public User(String name, String id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
