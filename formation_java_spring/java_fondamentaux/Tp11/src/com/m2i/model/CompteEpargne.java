
package com.m2i.model;

public non-sealed class CompteEpargne extends CompteBancaire implements InteretCalculable {
    protected double tauxInteret;

    public CompteEpargne(String titulaire, double solde, StatutCompte statut, double tauxInteret) {
        super(titulaire, solde, statut);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public double calculerInteret() {
        return solde * tauxInteret;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Taux d'intérêt : " + tauxInteret * 100 + " %");
    }
}
