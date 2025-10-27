package com.m2i.model;

import com.m2i.service.Exportable;

public class Directeur extends Employe implements Exportable {
    public Directeur(String nom, String matricule, double salaire) {
        super(nom, matricule, salaire);
    }

    @Override
    public double calculerPrime() {
        return salaire * 0.2;
    }

    @Override
    public String exporterTexte() {
        return "Directeur;" + nom + ";" + matricule + ";" + salaire;
    }
}