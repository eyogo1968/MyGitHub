package com.m2i.app;

import com.m2i.utils.Calculatrice;
import com.m2i.model.*;
import com.m2i.test.TestAnimal;

public class Main {
    public static void main(String[] args) {
    	
        System.out.println("------------------------");

        // Tâche 1 : Surcharge de méthodes
        Calculatrice calc = new Calculatrice();
        System.out.println(calc.addition(2, 3));
        System.out.println(calc.addition(2.5, 3.5));
        System.out.println(calc.addition(1, 2, 3));

        System.out.println("------------------------");
        
        // Tâche 2 : POJO vs JavaBean
        ProduitPOJO pojo = new ProduitPOJO();
        pojo.nom = "Stylo";
        pojo.prix = 1.5;
        System.out.println(pojo.nom + " - " + pojo.prix);

        ProduitBean bean = new ProduitBean();
        bean.setNom("Cahier");
        bean.setPrix(2.0);
        System.out.println(bean.getNom() + " - " + bean.getPrix());

        System.out.println("------------------------");

        // Tâche 3 : DTO et VO
        ClientDTO client = new ClientDTO("alice", "alice@mail.com");
        System.out.println(client.getUsername() + " - " + client.getEmail());

        MontantVO montant = new MontantVO(100.0, "EUR");
        System.out.println(montant.getValeur() + " " + montant.getDevise());

        System.out.println("------------------------");

        // Tâche 4 : Record
        EmployeRecord emp = new EmployeRecord("Bob", 30);
        System.out.println(emp);

        System.out.println("------------------------");

        // Tâche 6 : this et static
        new Voiture("Renault");
        new Voiture("Peugeot");
        Voiture.afficherCompteur();

        System.out.println("------------------------");

        //TestAnimal
        TestAnimal ta = new TestAnimal();
        ta.tester();
        
        System.out.println("------------------------");

    }
}