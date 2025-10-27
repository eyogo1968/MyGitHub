package com.m2i.model;

import java.util.ArrayList;
import java.util.List;

public sealed class CompteBancaire permits CompteCourant, CompteEpargne {
    protected static int compteur = 0;
    protected int id;
    protected String titulaire;
    protected double solde;
    private StatutCompte statut;
    private List<String> transactions = new ArrayList<>();

    public CompteBancaire(String titulaire, double solde, StatutCompte statut) {
        this.id = ++compteur;
        this.titulaire = titulaire;
        this.solde = solde;
        this.statut = statut;
        transactions.add("Ouverture du compte");
    }
    

    public void ajouterTransaction(String t) {
    	transactions.add(t);
    }


    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            transactions.add("Dépôt de " + montant + " €");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            transactions.add("Retrait de " + montant + " €");
        } else {
            System.out.println("Fonds insuffisants.");
        }
    }

    public void afficherInfos() {
        System.out.println("Compte #" + id + " - Titulaire: " + titulaire +
                " - Solde: " + solde + " € - Statut: " + statut);
    }

    @Override
    public String toString() {
        return "Compte #" + id + " - Titulaire: " + titulaire +
                " - Solde: " + solde + " € - Statut: " + statut;
    }

    // Classe interne
    public class HistoriqueLocal {
        public void afficherDerniereOperation() {
            if (!transactions.isEmpty()) {
                System.out.println("Dernière opération: " + transactions.get(transactions.size() - 1));
            } else {
                System.out.println("Aucune opération enregistrée.");
            }
        }
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getTitulaire() { return titulaire; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
    public StatutCompte getStatut() { return statut; }
    public void setStatut(StatutCompte statut) { this.statut = statut; }
    public List<String> getTransactions() { return transactions; }
}