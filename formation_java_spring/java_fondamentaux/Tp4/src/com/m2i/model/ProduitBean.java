package com.m2i.model;

public class ProduitBean {
    private String nom;
    private double prix;

    public ProduitBean() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}