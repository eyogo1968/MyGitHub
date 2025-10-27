package com.m2i.app;

import com.m2i.model.CompteBancaire;
import com.m2i.model.Transaction;

public class Main {
    public static void main(String[] args) {
        // Création d’un compte
        CompteBancaire compte1 = new CompteBancaire("Alice", 1000);
        compte1.afficherInfos();

        // Dépôt
        compte1.deposer(200);
        compte1.afficherInfos();

        // Retrait valide
        compte1.retirer(150);
        compte1.afficherInfos();

        // Retrait invalide
        compte1.retirer(2000);

        // Transaction valide
        Transaction t1 = new Transaction(1L, compte1, 150f, "debit");
        t1.afficherDetails();

        // Transaction invalide
        Transaction t2 = new Transaction(2L, compte1, 300f, "virement");
        t2.afficherDetails();
    }
}