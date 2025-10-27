package fr.aelion.java;

import fr.aelion.java.data.entity.Contact;
import fr.aelion.java.services.ContactService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactPU");
        EntityManager em = emf.createEntityManager();

        ContactService service = new ContactService(em);

        service.addDemoContacts();
        System.out.println("=== Liste des contacts ===");
        for (Contact c : service.listContacts()) {
            System.out.println(c);
        }

        System.out.println("\n=== Mise à jour d'un contact ===");
        service.updateContactEmail(1, "nouvel.email@ex.com");

        System.out.println("\n=== Suppression d'un contact ===");
        service.deleteContact(2);

        System.out.println("\n=== Liste mise à jour ===");
        for (Contact c : service.listContacts()) {
            System.out.println(c);
        }

        em.close();
        emf.close();

    }
}