package com.m2i.app;

import com.m2i.exceptions.SoldeInsuffisantException;
import com.m2i.model.CompteBancaire;
import com.m2i.model.StatutCompte;
import com.m2i.model.Transaction;
import com.m2i.utils.FichierUtils;

import java.util.List;

public class M2iBankApp {

    public static void main(String[] args) {
        // Tâche 1 : Exception métier
        CompteBancaire compte = new CompteBancaire("Alice", 500.0, StatutCompte.ACTIF);
        try {
            compte.retirer(150.0);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            System.out.println("Solde actuel : " + compte.getSolde() + " €");
        }

        // Tâche 2 : Exception non vérifiée
        Transaction t = new Transaction();
        try {
            t.setMontant(-50.0);
        } catch (Exception e) {
            System.out.println("Erreur transaction : " + e.getMessage());
        }

        // Tâche 3 : Lecture de fichier
        FichierUtils.lireOperations("operations.txt");
        FichierUtils.lireOperations("test.txt"); // fichier inexistant

        // Tâche 4 : Génération de rapport
        FichierUtils.genererRapport("rapport.txt", List.of(
                "Nombre de comptes : 5",
                "Solde global : 12500.0 €",
                "Nombre de transactions : 12"
        ));

        // Tâche 5 : Lecture filtrée
        FichierUtils.afficherOperationsParType("operations.txt", "debit");
    }
}