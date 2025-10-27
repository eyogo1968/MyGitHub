package com.m2i.model;

public sealed class CompteBancaire permits CompteCourant, CompteEpargne {
	
    protected String titulaire;
    protected double solde;
    public static int nbComptes = 0;

    // Constructeur par défaut
    public CompteBancaire() {
        this.solde = 0;
        nbComptes++;
    }

    // Constructeur avec paramètres
    public CompteBancaire(String titulaire, double solde) {
        this.titulaire = titulaire;
        setSolde(solde);
        nbComptes++;
    }

    public void afficherInfos() {
        System.out.println("Titulaire : " + titulaire);
        System.out.println("Solde : " + solde + " €");
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " € effectué.");
        }
    }

    public void retirer(double montant) {
        solde -= montant;
        System.out.println("Retrait de " + montant + " € effectué.");
    }

    // Getters et Setters
    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        if (solde >= 0) {
            this.solde = solde;
        } else {
            System.out.println("Le solde ne peut pas être négatif.");
        }
    }
}