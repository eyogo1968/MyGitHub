package com.m2i.app;

import com.m2i.utils.M2iBankUtils;

import java.util.Scanner;

public class M2iBankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("""
                === M2iBank ===
                1. Créer un client
                2. Créer un compte
                3. Effectuer une transaction
                4. Afficher l’historique
                5. Générer un rapport
                0. Quitter
                """);
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> M2iBankUtils.creerClient(scanner);
                case 2 -> M2iBankUtils.creerCompte(scanner);
                case 3 -> M2iBankUtils.effectuerTransaction(scanner);
                case 4 -> M2iBankUtils.afficherHistorique();
                case 5 -> M2iBankUtils.genererRapport();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }
}