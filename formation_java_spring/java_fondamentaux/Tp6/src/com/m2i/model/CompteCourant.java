package com.m2i.model;

public final class CompteCourant extends CompteBancaire{
	
	protected double decouvert;

    // Constructeur avec paramètres
    public CompteCourant(String titulaire, double solde) {
        super(titulaire,solde);
        this.decouvert = 500.0;
    }

    // Constructeur avec paramètres
    public CompteCourant(String titulaire, double solde, double decouvert) {
        super(titulaire,solde);
        this.decouvert = decouvert;
    }
    
    @Override
    public void afficherInfos() {
    	super.afficherInfos();
        System.out.println("decouvert autorise : " + decouvert);
    }
    
    @Override
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            super.retirer(montant);
            System.out.println("Retrait de " + montant + " € effectué.");
            System.out.println("Le nouveau solde est de " + solde + " € effectué.");
        } 
    }
}
