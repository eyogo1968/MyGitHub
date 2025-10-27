package fr.aelion.java.services;

import fr.aelion.java.data.dao.ContactDAO;
import fr.aelion.java.data.entity.Contact;

import javax.persistence.EntityManager;
import java.util.List;

public class ContactService {

    private ContactDAO dao;

    public ContactService(EntityManager em) {
        this.dao = new ContactDAO(em);
    }

    public void addDemoContacts() {
        Contact c1 = new Contact();
        c1.setName("Durand");
        c1.setFirstName("Alice");
        c1.setTel("0102030405");
        c1.setEmail("alice@ex.com");
        dao.create(c1);
    }

    public List<Contact> listContacts() {
        return dao.findAll();
    }

    public void updateContactEmail(int id, String email) {
        Contact c = dao.find(id);
        if (c != null) {
            c.setEmail(email);
            dao.update(c);
        }
    }

    public void deleteContact(int id) {
        Contact c = dao.find(id);
        if (c != null) {
            dao.delete(c);
        }
    }
}