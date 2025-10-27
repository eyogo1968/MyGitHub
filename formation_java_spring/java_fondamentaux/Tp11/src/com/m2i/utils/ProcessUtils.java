// com.m2i.utils.ProcessUtils.java
package com.m2i.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessUtils {
    public static void lancerScriptSauvegarde() {
        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "-n", "3", "google.com");
            Process process = pb.start();
            
            StringBuilder sb = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                sb.append(ligne).append(System.lineSeparator());
            }
            
            System.out.println("Resultat processus: "+sb);

            suivreProcessus(process);

        } catch (IOException e) {
            System.out.println("Erreur lors du lancement du processus : " + e.getMessage());
        }
    }

    public static void suivreProcessus(Process process) {
        ProcessHandle handle = process.toHandle(); // fonctionne toujours

        System.out.println("PID : " + handle.pid());
        handle.info().user().ifPresent(user -> System.out.println("Utilisateur : " + user));
        handle.info().startInstant().ifPresent(start -> System.out.println("Démarré à : " + start));
        handle.info().totalCpuDuration().ifPresent(duration -> System.out.println("Durée CPU : " + duration));
    }
}