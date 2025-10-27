package com.m2i.model;

import com.m2i.service.Exportable;

public class Conseiller extends Employe implements Exportable {
    public Conseiller(String nom, String matricule, double salaire) {
        super(nom, matricule, salaire);
    }

    @Override
    public double calculerPrime() {
        return salaire * 0.1;
    }

    @Override
    public String exporterTexte() {
        return "Conseiller;" + nom + ";" + matricule + ";" + salaire;
    }
}