package com.m2i.model;

public abstract class AbstractTransactionService {
	
	protected CompteBancaire compte;
	
	abstract void executerTransaction(double montant);
	
	public AbstractTransactionService(CompteBancaire compte) {
		this.compte = compte;
	}
	
	void afficherSolde() {
		System.out.println("solde : "+ compte.getSolde());
	}
}
