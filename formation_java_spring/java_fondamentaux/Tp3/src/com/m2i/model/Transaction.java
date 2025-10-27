package com.m2i.model;

public class Transaction {
    private Long id;
    private CompteBancaire compte;
    public Float montant;
    private String type;
    public static Integer nbTransactions = 0;

    // Constructeur
    public Transaction(Long id, CompteBancaire compte, Float montant, String type) {
        this.id = id;
        this.compte = compte;
        this.montant = montant;
        setType(type);
        nbTransactions++;
    }

    public void afficherDetails() {
        System.out.println("Transaction #" + id);
        System.out.println("Montant : " + montant + " €");
        System.out.println("Type : " + type);
        System.out.println("Titulaire du compte : " + compte.getTitulaire());
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("debit") || type.equalsIgnoreCase("credit")) {
            this.type = type;
        } else {
            System.out.println("Type de transaction (" + type + ") invalide");
        }
    }
}