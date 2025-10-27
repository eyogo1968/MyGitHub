package com.m2i.utils;

import com.m2i.model.*;
import java.time.LocalDate;
import java.util.*;

public class M2iBankUtils {

    // === Données persistées en mémoire ===
    private static final List<Client> clients = new ArrayList<>();
    private static final List<CompteBancaire> comptes = new ArrayList<>();
    private static final HistoriqueOperation historique = new HistoriqueOperation();

    // === Actions ===

    public static void creerClient(Scanner sc) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Email : ");
        String email = sc.nextLine();
        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Client premium ? (oui/non) : ");
        String rep = sc.nextLine().trim().toLowerCase();

        Client client;
        if (rep.equals("oui")) {
            System.out.print("Taux de rémunération : ");
            double taux = sc.nextDouble();
            System.out.print("Découvert autorisé : ");
            double decouvert = sc.nextDouble();
            sc.nextLine(); // flush
            client = new ClientPremium(nom, email, username, taux, decouvert);
        } else {
            client = new Client(nom, email, username);
        }

        clients.add(client);
        System.out.println("✅ Client créé : " + client);
    }

    public static void creerCompte(Scanner sc) {
        if (clients.isEmpty()) {
            System.out.println("⚠️ Aucun client disponible. Créez un client d'abord.");
            return;
        }

        System.out.println("Sélectionnez un client :");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getUsername());
        }
        int choix = sc.nextInt() - 1;
        sc.nextLine(); // flush
        Client client = clients.get(choix);

        System.out.print("Type de compte (courant/epargne) : ");
        String type = sc.nextLine().trim().toLowerCase();
        System.out.print("Solde initial : ");
        double solde = sc.nextDouble();

        CompteBancaire compte;
        if (type.equals("courant")) {
            System.out.print("Découvert autorisé : ");
            double decouvert = sc.nextDouble();
            compte = new CompteCourant(client.getNom(), solde, decouvert);
        } else {
            System.out.print("Taux d'intérêt : ");
            double taux = sc.nextDouble();
            compte = new CompteEpargne(client.getNom(), solde, taux);
        }

        comptes.add(compte);
        System.out.println("✅ Compte créé : " + compte);
    }

    public static void effectuerTransaction(Scanner sc) {
        if (comptes.isEmpty()) {
            System.out.println("⚠️ Aucun compte disponible.");
            return;
        }

        System.out.println("Sélectionnez un compte :");
        for (int i = 0; i < comptes.size(); i++) {
            System.out.println((i + 1) + ". " + comptes.get(i));
        }
        int choix = sc.nextInt() - 1;
        CompteBancaire compte = comptes.get(choix);

        System.out.print("Type d'opération (depot/retrait) : ");
        sc.nextLine(); // flush
        String type = sc.nextLine().trim().toLowerCase();
        System.out.print("Montant : ");
        double montant = sc.nextDouble();

        if (type.equals("depot")) {
            compte.deposer(montant);
            historique.ajouterTransaction(new Transaction(TypeOperation.DEPOT, montant, LocalDate.now()));
        } else if (type.equals("retrait")) {
            compte.retirer(montant);
            historique.ajouterTransaction(new Transaction(TypeOperation.RETRAIT, montant, LocalDate.now()));
        } else {
            System.out.println("❌ Type d'opération invalide.");
            return;
        }

        System.out.println("✅ Opération effectuée. Nouveau solde : " + compte.getSolde() + " €");
    }

    public static void afficherHistorique() {
        List<Transaction> toutes = historique.getToutes();
        if (toutes.isEmpty()) {
            System.out.println("📭 Aucun historique disponible.");
        } else {
            System.out.println("📜 Historique des transactions :");
            toutes.forEach(System.out::println);
        }
    }

    public static void genererRapport() {
    	RapportActivite.generer(clients, comptes, historique);
    }
}
