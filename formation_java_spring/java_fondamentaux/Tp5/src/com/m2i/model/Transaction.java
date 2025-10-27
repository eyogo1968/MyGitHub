package com.m2i.model;

public class Transaction {

	private static int compteur = 0;
	private int id;
	private CompteBancaire compte;
	private double montant;
	private String type; //(valeurs : "debit" ou "credit")
	
	public Transaction() {
		this.id = ++compteur;
		this.type = type;
		this.montant = montant;
		this.compte = compte;
	}

	public Transaction(CompteBancaire compte,double montant,String type) {
		this.id = ++compteur;
		this.type = type;
		this.montant = montant;
		this.compte = compte;
	}

	//affiche ID, type, montant, titulaire
	public void afficherDetails() {
		System.out.println("\r\nid : "+id);
		System.out.println("type : "+type);
		System.out.println("montant : "+montant+ " €");		
		System.out.println("Titulaire : "+compte.getTitulaire());		
	}

	public static int getCompteur() {
		return compteur;
	}

//	public static void setCompteur(int compteur) {
//		Transaction.compteur = compteur;
//	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public CompteBancaire getCompte() {
		return compte;
	}

	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
