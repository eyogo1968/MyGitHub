package com.m2i.utils;

import java.util.Arrays;

public class BanqueUtils {

    public static void afficherSoldes(double[] soldes) {
        for (int i = 0; i < soldes.length; i++) {
            System.out.println("Solde[" + i + "] = " + soldes[i]);
        }
    }

    public static double calculerMoyenne(double[] soldes) {
        double total = 0;
        for (double s : soldes) total += s;
        return soldes.length > 0 ? total / soldes.length : 0;
    }

    public static void afficherMatriceTransactions(double[][] montants) {
        for (int i = 0; i < montants.length; i++) {
            for (int j = 0; j < montants[i].length; j++) {
                System.out.print("[" + i + "][" + j + "] = " + montants[i][j] + "  ");
            }
            System.out.println();
        }
    }
}