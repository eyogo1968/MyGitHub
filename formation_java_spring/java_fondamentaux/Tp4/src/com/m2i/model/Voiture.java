package com.m2i.model;

public class Voiture {
    private String marque;
    private static int compteur = 0;

    public Voiture(String marque) {
        this.marque = marque;
        compteur++;
    }

    public static void afficherCompteur() {
        System.out.println("Nombre de voitures créées : " + compteur);
    }
}