package com.m2i.utils;

import com.m2i.model.StatutCompte;

public class BanqueUtils {

    public static String evaluerMontant(double montant) {
        if (montant < 100) return "Montant faible";
        else if (montant <= 1000) return "Montant moyen";
        else return "Montant élevé";
    }

    public static String typeOperation(int code) {
        return switch (code) {
            case 1 -> "Dépôt";
            case 2 -> "Retrait";
            case 3 -> "Virement";
            default -> "Inconnu";
        };
    }

    public static String messageOperation(String type) {
        return switch (type) {
            case "Dépôt" -> {
                yield "Vous avez effectué un dépôt.";
            }
            case "Retrait" -> {
                yield "Vous avez effectué un retrait.";
            }
            case "Virement" -> {
                yield "Vous avez effectué un virement.";
            }
            default -> {
                yield "Type d'opération inconnu.";
            }
        };
    }

    public static Integer doublerMontant(int montant) {
        return montant * 2; // autoboxing implicite
    }

    public static int extraireValeur(Integer montant) {
        return montant; // unboxing implicite
    }

    public static double sommeMontants(double... montants) {
        double somme = 0;
        for (double m : montants) {
            somme += m;
        }
        return somme;
    }

    public static void afficherTousStatuts() {
        for (StatutCompte statut : StatutCompte.values()) {
            System.out.println(statut);
        }
    }
}