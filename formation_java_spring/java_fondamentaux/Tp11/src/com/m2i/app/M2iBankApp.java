// com.m2i.app.M2iBankApp.java
package com.m2i.app;

import com.m2i.model.*;
import com.m2i.service.TransactionService;
import com.m2i.utils.FichierUtils;
import com.m2i.utils.ProcessUtils;
import com.m2i.utils.ScriptUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class M2iBankApp {
    public static void main(String[] args) {
        System.out.println("=== M2iBankApp - TP 11 ===");

        // Tâche 1 : Lancer un processus système avec ProcessBuilder
        // Tâche 2 : Suivre un processus avec ProcessHandle
        ProcessUtils.lancerScriptSauvegarde();

        // Tâche 3 : Utilisation de Optional pour sécuriser les accès
        Optional<Client> clientOpt = Optional.of(new Client(1, "Alice", TypeClient.PARTICULIER));
        clientOpt.ifPresentOrElse(
            client -> System.out.println("Client trouvé : " + client),
            () -> System.out.println("Client introuvable.")
        );

        // Tâche 4 : Générer un relevé avec l’API DateTime
        CompteBancaire compte = new CompteBancaire("Alice", 1500.0, StatutCompte.ACTIF);
        FichierUtils.genererReleveAvecHorodatage(compte);

        // Tâche 5 : Afficher les opérations du jour
        List<Transaction> toutes = List.of(
            new Transaction(TypeOperation.DEPOT, 200.0, LocalDate.now()),
            new Transaction(TypeOperation.RETRAIT, 100.0, LocalDate.of(2023, 1, 1))
        );
        List<Transaction> duJour = TransactionService.filtrerOperationsDuJour(toutes);
        System.out.println("Opérations du jour :");
        duJour.forEach(System.out::println);

        // Tâche 6 : Fuseaux horaires et Instant
        Transaction t = new Transaction(TypeOperation.VIREMENT, 300.0, LocalDate.now());
        System.out.println("Transaction :" + t);
        Instant horodatage = Instant.now();
        System.out.println("Horodatage UTC : " + horodatage);
        System.out.println("Heure locale : " +
            ZonedDateTime.ofInstant(horodatage, ZoneId.systemDefault()));
    }
}