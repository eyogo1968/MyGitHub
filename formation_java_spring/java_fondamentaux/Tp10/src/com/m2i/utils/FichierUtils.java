package com.m2i.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FichierUtils {

    public static void lireOperations(String chemin) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(chemin))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                System.out.println("Opération : " + ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
    
    public static void genererRapport(String chemin, List<String> lignes) {
        try {
            Files.write(Path.of(chemin), lignes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Rapport généré avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du rapport : " + e.getMessage());
        }
    }
    
    public static void afficherOperationsParType(String chemin, String type) {
        try (Stream<String> lignes = Files.lines(Path.of(chemin))) {
            lignes.filter(l -> l.contains(type))
                  .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture filtrée : " + e.getMessage());
        }
    }
}
