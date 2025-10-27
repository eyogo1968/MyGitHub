package com.m2i.model;

public class MontantVO {
    private final double valeur;
    private final String devise;

    public MontantVO(double valeur, String devise) {
        if (valeur <= 0) {
            throw new IllegalArgumentException("La valeur doit être positive.");
        }
        this.valeur = valeur;
        this.devise = devise;
    }

    public double getValeur() {
        return valeur;
    }

    public String getDevise() {
        return devise;
    }
}