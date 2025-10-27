package com.m2i.model;

public class Client {
    private String nom;
    private TypeClient type;

    public Client(String nom, TypeClient type) {
        this.nom = nom;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public TypeClient getType() {
        return type;
    }

    @Override
    public String toString() {
        return nom + " (" + type + ")";
    }
}