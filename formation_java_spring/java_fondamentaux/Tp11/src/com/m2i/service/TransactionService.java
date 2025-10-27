// com.m2i.service.TransactionService.java
package com.m2i.service;

import com.m2i.model.Transaction;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
    public static List<Transaction> filtrerOperationsDuJour(List<Transaction> liste) {
        LocalDate aujourdHui = LocalDate.now();
        return liste.stream()
            .filter(t -> t.getDate().equals(aujourdHui))
            .collect(Collectors.toList());
    }
}