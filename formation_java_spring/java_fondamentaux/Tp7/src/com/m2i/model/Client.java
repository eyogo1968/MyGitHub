package com.m2i.model;

public class Client {
    protected String nom;
    protected String email;
    protected String username;

    public Client(String nom, String email, String username) {
        this.nom = nom;
        this.email = email;
        this.username = username;
    }

    public String afficherInfos() {
        return "Client : " + nom + " | Email : " + email + " | Username : " + username;
    }

    public String afficherInfos(String prefix) {
        return prefix + afficherInfos();
    }

    @Override
    public String toString() {
        return afficherInfos();
    }

    // Getters
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
}
