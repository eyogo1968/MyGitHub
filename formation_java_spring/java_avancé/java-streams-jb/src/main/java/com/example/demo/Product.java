package com.example.demo;

public class Product {
    private long id;
    private String name;
    private int price;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(long id, String name,int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
