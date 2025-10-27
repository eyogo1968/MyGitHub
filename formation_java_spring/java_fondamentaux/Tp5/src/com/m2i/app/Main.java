package com.m2i.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.m2i.model.CompteBancaire;
import com.m2i.model.Transaction;
import com.m2i.utils.BanqueUtils;
import com.m2i.utils.Historique;

public class Main {

	public static void main(String[] args) {
		
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		List<CompteBancaire> comptes = new ArrayList<>();
		
		do {
			
			System.out.println("\r\n");
			BanqueUtils.afficherMenu(); 
			System.out.println("\r\nChoix : ");
			
			choix = sc.nextInt();
			
			switch (choix) {
			
				case 1 -> {
					String nom = BanqueUtils.saisirTexte(sc, "Nom du titulaire");
					double solde = BanqueUtils.saisirMontant(sc);
					CompteBancaire compte = new CompteBancaire(nom,solde);
					comptes.add(compte);
					System.out.println("\r\nCompte cree ID = "+compte.getId()+ "\r\n");
				}
				
				case 2 -> {
					int id = BanqueUtils.demanderIdCompte(sc);
					CompteBancaire c = BanqueUtils.trouverCompte(id, comptes);
					if(c!= null) {
						double montant = BanqueUtils.saisirMontant(sc);
						c.deposer(montant);
						Transaction t = new Transaction(c,montant,"credit");
						Historique.ajouterTransaction(c.getId(),t);
						System.out.println("Depot effectue\r\n");
					} else System.out.println("\r\nCompte introuvable\r\n");
				}
				
				case 3 -> {
					int id = BanqueUtils.demanderIdCompte(sc);
					CompteBancaire c = BanqueUtils.trouverCompte(id, comptes);
					if(c!= null) {
						double montant = BanqueUtils.saisirMontant(sc);
						c.retirer(montant);
						Transaction t = new Transaction(c,montant,"debit");
						Historique.ajouterTransaction(c.getId(),t);
						System.out.println("Retrait effectue\r\n");
					} else System.out.println("\r\nCompte introuvable\r\n");
				}
				
				case 4 -> {
					System.out.println("\r\nAffichage des comptes\r\n");
					for(CompteBancaire c : comptes) {
						c.afficherInfos();
					}
				}
				
				case 5 -> {
					System.out.println("\r\nAffichage des transactions\r\n");
					int id = BanqueUtils.demanderIdCompte(sc);
					Historique.afficherHistorique(id);
				}
				
				default -> System.out.println("\r\nChoix introuvable\r\n");
			}
		}
		while (choix != 6);
	}
}
