package com.m2i.model;

import java.time.LocalDate;

import com.m2i.exceptions.DonneeInvalideException;

public class Transaction {
    private TypeOperation type;
    private double montant;
    private LocalDate date;
    
    public Transaction() {
        this.date = LocalDate.now();
    }

    public Transaction(TypeOperation type, double montant, LocalDate date) {
        this.type = type;
        this.setMontant(montant);
        this.date = date;
    }
    
    public void setMontant(double montant) {
        if (montant <= 0) {
            throw new DonneeInvalideException("Le montant doit être supérieur à zéro.");
        }
        this.montant = montant;
    }


    public TypeOperation getType() { return type; }
    public double getMontant() { return montant; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return type + " de " + montant + " € le " + date;
    }
}