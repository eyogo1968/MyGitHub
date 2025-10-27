package com.m2i.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoriqueOperation {
    private List<Transaction> transactions = new ArrayList<>();

    public void ajouterTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> filtrerParType(TypeOperation type) {
        return transactions.stream().filter(t -> t.getType() == type).collect(Collectors.toList());
    }

    public List<Transaction> filtrerParMontant(double min, double max) {
        return transactions.stream().filter(t -> t.getMontant() >= min && t.getMontant() <= max).collect(Collectors.toList());
    }

    public List<Transaction> filtrerParDate(LocalDate date) {
        return transactions.stream().filter(t -> t.getDate().equals(date)).collect(Collectors.toList());
    }

    public List<Transaction> getToutes() {
        return transactions;
    }
}