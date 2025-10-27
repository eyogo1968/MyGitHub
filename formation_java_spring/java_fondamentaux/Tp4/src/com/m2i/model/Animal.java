package com.m2i.model;

public class Animal {
    public String nom;
    protected int age;
    private String espece;

    public Animal(String nom, int age, String espece) {
        this.nom = nom;
        this.age = age;
        this.espece = espece;
    }
}