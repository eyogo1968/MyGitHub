package com.m2i.model;

public interface InteretCalculable {
    double calculerInteret();

    default void afficherInteret() {
        System.out.println(formaterInteret(calculerInteret()));
    }

    private String formaterInteret(double interet) {
        return "Intérêt calculé : " + String.format("%.2f", interet) + " €";
    }
}