package com.m2i.model;

import java.time.LocalDate;

public class Transaction {
    private TypeOperation type;
    private double montant;
    private LocalDate date;

    public Transaction(TypeOperation type, double montant, LocalDate date) {
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    public TypeOperation getType() { return type; }
    public double getMontant() { return montant; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return type + " de " + montant + " € le " + date;
    }
}
