package com.m2i.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.m2i.model.Transaction;

public class Historique {

	//(clé = ID du compte, valeur = liste des transactions associées)
	private static Map<Integer, List<Transaction>> historiqueParCompte = new HashMap<>();
	
	public static void ajouterTransaction(int idCompte, Transaction transaction) {
		List<Transaction> listeTransactions = getTransactions(idCompte);
		if(listeTransactions == null) {
			listeTransactions = new ArrayList<Transaction>();
			historiqueParCompte.put(idCompte, listeTransactions);
		}
		listeTransactions.add(transaction);
	}

	public static void afficherHistorique(int idCompte) {
		List<Transaction> listeTransactions = historiqueParCompte.get(idCompte);
		if(listeTransactions == null || listeTransactions.isEmpty()) {
			System.out.println("Aucune transaction pour ce compte");
		} else {
			for (Transaction t : listeTransactions) {
				t.afficherDetails();
			}
		}
	}

	public static List<Transaction> getTransactions(int idCompte){
		return historiqueParCompte.get(idCompte);
	}
}
