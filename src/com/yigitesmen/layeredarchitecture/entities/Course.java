package com.yigitesmen.layeredarchitecture.entities;

public class Course {
    final private long id;
    private String name;
    private double price;
    private final Instructor instructor;
    private final Category category;

    public Course(long id, String name, double price, Instructor instructor, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.instructor = instructor;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price < 0 ? 0.0 : price;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Category getCategory() {
        return category;
    }
}
