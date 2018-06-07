package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desk;
    private long created;
    private String[] comments;

    public Item(String name, String desk, long created) {
        this.name = name;
        this.desk = desk;
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesk() {
        return desk;
    }

    public long getCreated() {
        return created;
    }

    public String[] getComments() {
        return comments;
    }
}
