package com.m2i.app;

import java.util.List;

import com.m2i.model.CompteBancaire;

public class M2iBankApp {

	public static void afficherComptes(List<CompteBancaire> comptes) {
		
		for(int i = 0; i < comptes.size(); i++) {
			CompteBancaire c = comptes.get(i);
			c.afficherInfos();
		}
		
		for(CompteBancaire c : comptes) {
			c.afficherInfos();
		}
		
		comptes.forEach(c -> c.afficherInfos());
	}
	
	public static void afficherComptesPairs(List<CompteBancaire> comptes) {
		for(CompteBancaire c : comptes) {
			if(c.getId() %2 != 0 ) {
				continue;
			}
			c.afficherInfos();
		}
	}
}