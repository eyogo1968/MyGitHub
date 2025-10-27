package com.m2i.model;

public abstract class Employe {
    protected String nom;
    protected String matricule;
    protected double salaire;

    public Employe(String nom, String matricule, double salaire) {
        this.nom = nom;
        this.matricule = matricule;
        this.salaire = salaire;
    }

    public abstract double calculerPrime();

    public String afficherInfos() {
        return "Employé : " + nom + " | Matricule : " + matricule + " | Salaire : " + salaire;
    }

    public String afficherInfos(String prefix) {
        return prefix + afficherInfos();
    }

    @Override
    public String toString() {
        return afficherInfos();
    }
}