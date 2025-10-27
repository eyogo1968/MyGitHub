package com.m2i.utils;

import java.util.List;

import com.m2i.model.Client;
import com.m2i.model.CompteBancaire;
import com.m2i.model.HistoriqueOperation;

public class RapportActivite {
    public static void generer(List<Client> clients, List<CompteBancaire> comptes, HistoriqueOperation historique) {
    	int totalClients = clients.size();
        int totalComptes = comptes.size();
        double soldeGlobal = comptes.stream().mapToDouble(CompteBancaire::getSolde).sum();
        int totalTransactions = historique.getToutes().size();

        System.out.println("=== Rapport d’activité ===");
        System.out.println("👥 Nombre total de clients : " + totalClients);
        System.out.println("🏦 Nombre total de comptes : " + totalComptes);
        System.out.println("💰 Solde global de la banque : " + soldeGlobal + " €");
        System.out.println("🔁 Nombre total de transactions : " + totalTransactions);
    }
}