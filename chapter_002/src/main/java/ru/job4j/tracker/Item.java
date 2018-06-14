package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desk;
    private long created;
    private String[] comments;


    public Item() {
    }

    public Item(String name, String desk, long created) {
        this.name = name;
        this.desk = desk;
        this.created = created;
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String name, String desk) {
        this.name = name;
        this.desk = desk;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getDesk() {
        return desk;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return created;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String[] getComments() {
        return comments;
    }
}
