package com.m2i.model;

public class RetraitService extends AbstractTransactionService {
	
	public RetraitService(CompteBancaire compte) {
		 super(compte);
	}
	
	@Override
	public void executerTransaction(double montant) {
		compte.retirer(montant);
	}
}
