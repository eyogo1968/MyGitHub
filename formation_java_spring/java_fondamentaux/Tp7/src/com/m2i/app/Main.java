package com.m2i.app;

import java.util.ArrayList;
import java.util.List;

import com.m2i.model.CompteBancaire;
import com.m2i.model.CompteCourant;
import com.m2i.model.CompteEpargne;

public class Main {
	public static void main(String[] args) {
		List<CompteBancaire> comptes = new ArrayList<>();
		comptes.add(new CompteCourant("Alice", 1000, 200));
		comptes.add(new CompteEpargne("Bob", 2000, 0.03));

		for (CompteBancaire compte : comptes) {
		    compte.afficherInfos();
		    if (compte instanceof CompteEpargne ce) {
		        System.out.println("Intérêts : " + ce.calculerInteret());
		    }
		}
	}
}
