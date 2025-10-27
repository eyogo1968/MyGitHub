package com.m2i.app;

import java.util.ArrayList;
import java.util.List;

import com.m2i.model.CompteBancaire;
import com.m2i.model.CompteCourant;
import com.m2i.model.CompteEpargne;

public class Main {
    public static void main(String[] args) {
    	
        // Liste de compte bancaire
        List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
        
        CompteBancaire cc = new CompteCourant("Alice",1000,300.0);
        CompteBancaire ce = new CompteEpargne("Bob",2000,0.025);
        
        comptes.add(cc);
        comptes.add(ce);
        
        for (CompteBancaire c : comptes) {
        	c.afficherInfos();
        	System.out.println("----------------------------");
        }
    }
}