package fr.aelion.java.data.dao;

import fr.aelion.java.data.entity.Contact;

import javax.persistence.EntityManager;
import java.util.List;

public class ContactDAO {

    private EntityManager em;

    public ContactDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Contact contact) {
        em.getTransaction().begin();
        em.persist(contact);
        em.getTransaction().commit();
    }

    public Contact find(int id) {
        return em.find(Contact.class, id);
    }

    public List<Contact> findAll() {
        return em.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }

    public void update(Contact contact) {
        em.getTransaction().begin();
        em.merge(contact);
        em.getTransaction().commit();
    }

    public void delete(Contact contact) {
        em.getTransaction().begin();
        em.remove(em.contains(contact) ? contact : em.merge(contact));
        em.getTransaction().commit();
    }
}