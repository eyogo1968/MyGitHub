package com.m2i.model;

public class DepotService extends AbstractTransactionService {
	
	public DepotService(CompteBancaire compte) {
		 super(compte);
	}
	
	@Override
	public void executerTransaction(double montant) {
		compte.deposer(montant);
	}
}
