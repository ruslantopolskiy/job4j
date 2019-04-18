package ru.job4j.tracker;

public class Item {
    private String id;
    private String description;
    private String name;
    private long create;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public long getCreate() {
        return create;
    }





}