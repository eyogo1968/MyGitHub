package com.m2i.model;

public non-sealed class CompteEpargne extends CompteBancaire implements InteretCalculable {
	
	protected double tauxInteret;

    // Constructeur avec paramètres
    public CompteEpargne(String titulaire, double solde) {
        super(titulaire,solde);
        this.tauxInteret = 1.0;
    }

    // Constructeur avec paramètres
    public CompteEpargne(String titulaire, double solde, double tauxInteret) {
        super(titulaire,solde);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void afficherInfos() {
    	super.afficherInfos();
        System.out.println("tauxInteret : " + tauxInteret);
    }
    
    @Override
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
        	solde += montant;
            System.out.println("Retrait de " + montant + " € effectué.");
            System.out.println("Le nouveau solde est de " + solde + " € effectué.");
        } 
    }

	@Override
	public double calculerInteret() {
		return solde*tauxInteret;
	}
}
