package com.m2i.model;

public sealed class CompteBancaire permits CompteCourant, CompteEpargne {
	protected static int compteur = 0;
    protected int id;
    protected String titulaire;
    protected double solde;

    public CompteBancaire(String titulaire, double solde) {
        this.id = ++compteur;
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public void deposer(double montant) {
        if (montant > 0) solde += montant;
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) solde -= montant;
        else System.out.println("Fonds insuffisants.");
    }
    
    public String toString() {
        return "Compte #" + id + " - Titulaire: " + titulaire + " - Solde: " + solde + " €";
    }

    public void afficherInfos() {
        System.out.println("Compte #" + id + " - Titulaire: " + titulaire + " - Solde: " + solde + " €");
    }

    public int getId() { return id; }
    public String getTitulaire() { return titulaire; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}