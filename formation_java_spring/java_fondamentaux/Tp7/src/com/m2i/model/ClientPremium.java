package com.m2i.model;

import com.m2i.service.AvantageClient;

public class ClientPremium extends Client implements AvantageClient {
    private double tauxRemuneration;
    private double decouvertAutorise;

    public ClientPremium(String nom, String email, String username, double tauxRemuneration, double decouvertAutorise) {
        super(nom, email, username);
        this.tauxRemuneration = tauxRemuneration;
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void afficherAvantages() {
        System.out.println("Avantages Premium : Taux de rémunération = " + tauxRemuneration +
                ", Découvert autorisé = " + decouvertAutorise);
    }

    @Override
    public String afficherInfos() {
        return super.afficherInfos() + " [Premium]";
    }

    @Override
    public String toString() {
        return afficherInfos();
    }

    // Getters
    public double getTauxRemuneration() { return tauxRemuneration; }
    public double getDecouvertAutorise() { return decouvertAutorise; }
}