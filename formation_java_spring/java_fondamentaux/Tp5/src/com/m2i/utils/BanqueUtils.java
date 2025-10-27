package com.m2i.utils;

import java.util.List;
import java.util.Scanner;

import com.m2i.model.CompteBancaire;

public class BanqueUtils {

	public static void afficherMenu() {
		String menu = """
				======= MENU M2iBank =====
				1. Creer un compte
				2. Deposer de l'argent
				3. Retirer de l'argent
				4. Afficher les comptes
				5. Afficher les tgransactions
				6. Quitter
					   """;
		System.out.println(menu);
	}
	public static double saisirMontant(Scanner sc) { 
		System.out.println("Montant : ");
		return sc.nextDouble();
		
	}
	public static String saisirTexte(Scanner sc, String message) {
		System.out.println(message + " : ");
		sc.nextLine(); // vider le buffer
		return sc.nextLine();
	}
	public static int demanderIdCompte(Scanner sc) {
		System.out.println("ID du compte : ");
		sc.nextLine(); // vider le buffer
		return sc.nextInt();		
	}
	public static CompteBancaire trouverCompte(int id, List<CompteBancaire> comptes) {
		CompteBancaire result = null;
		for(CompteBancaire c : comptes) {
			if(c.getId() == id) {
				result = c;
			}
		}
		return result;
	}
}
