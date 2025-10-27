package com.m2i.model;

public class CompteBancaire {

	private static int compteur = 0; //(sert à générer un ID unique)
	private int id;
	private String titulaire;
	private double solde;
	
	public CompteBancaire(String titulaire, double solde) {
		compteur++;
		this.id = compteur;
		this.titulaire = titulaire;
		this.solde = solde;
	}

	//ajoute au solde
	public void deposer(double montant) {
		solde += montant;
	}
	
	//retire si solde suffisant
	public void retirer(double montant) {
		if(montant <= solde) {
			solde -= montant;
		} else {
			System.out.println("Solde infuffisant");
		}
	}
	
	//affiche ID, titulaire, solde
	public void afficherInfos() {
		System.out.println("\r\nID : "+id);
		System.out.println("Titulaire : "+titulaire);
		System.out.println("Solde : "+solde);
	}

//	public static int getCompteur() {
//		return compteur;
//	}
//
//	public static void setCompteur(int compteur) {
//		CompteBancaire.compteur = compteur;
//	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

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
		this.solde = solde;
	}
}
