package com.m2i.model;

public final class CompteCourant extends CompteBancaire {
    protected double decouvert;

    public CompteCourant(String titulaire, double solde, StatutCompte statut, double decouvert) {
        super(titulaire, solde, statut);
        this.decouvert = decouvert;
    }

    @Override
    public void retirer(double montant) {
        if (montant <= solde + decouvert) {
            solde -= montant;
        } else {
            System.out.println("Retrait refusé : dépassement du découvert autorisé.");
        }
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Découvert autorisé : " + decouvert + " €");
    }
}