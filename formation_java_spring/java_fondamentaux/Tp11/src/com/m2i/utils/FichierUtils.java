// com.m2i.utils.FichierUtils.java
package com.m2i.utils;

import com.m2i.model.CompteBancaire;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FichierUtils {
    public static void genererReleveAvecHorodatage(CompteBancaire compte) {
        LocalDateTime now = LocalDateTime.now();
        String horodatage = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        List<String> lignes = List.of(
            "Nom : " + compte.getTitulaire(),
            "Compte n° : " + compte.getId(),
            "Solde : " + compte.getSolde() + " €",
            "Généré le : " + horodatage
        );
        try {
            Files.write(Paths.get("releve_" + compte.getId() + ".txt"), lignes);
            System.out.println("Relevé généré.");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}