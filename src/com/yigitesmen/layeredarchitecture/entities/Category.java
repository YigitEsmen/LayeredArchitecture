package com.yigitesmen.layeredarchitecture.entities;

public class Category {
    final private long id;
    private String name;

    public Category(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
