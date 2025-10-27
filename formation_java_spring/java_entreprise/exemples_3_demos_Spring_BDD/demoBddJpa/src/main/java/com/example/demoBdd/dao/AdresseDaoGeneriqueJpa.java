package com.example.demoBdd.dao;

import com.example.demoBdd.config.MonSingloton;
import com.example.demoBdd.model.AdresseJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdresseDaoGeneriqueJpa implements DaoGenerique<AdresseJpa, Long> {
    @Override
    public List<AdresseJpa> getAll() {
        List<AdresseJpa> adresses = new ArrayList<>();
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
           em = MonSingloton.getInstance().getEmf().createEntityManager();
           tx = em.getTransaction();
           tx.begin();

            // prevoir ma requete
            TypedQuery<AdresseJpa> query = em.createQuery("select adr from ADRESSE adr", AdresseJpa.class);

            // traitement du resultats
            adresses = query.getResultList();

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
        return adresses;
    }

    @Override
    public AdresseJpa getById(Long id) {
        AdresseJpa adresse = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = MonSingloton.getInstance().getEmf().createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // prevoir ma requete // traitement du resultats
            adresse = em.find(AdresseJpa.class, id);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
        return adresse;
    }

    @Override
    public AdresseJpa create(AdresseJpa obj) {
        AdresseJpa adresse = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = MonSingloton.getInstance().getEmf().createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // prevoir ma requete // traitement du resultats
            // em.persist(obj);
            adresse = em.merge(obj); // => update and create if not existe

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
        return adresse;
    }

    @Override
    public void update(AdresseJpa obj) {
        AdresseJpa adresse = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = MonSingloton.getInstance().getEmf().createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // prevoir ma requete // traitement du resultats
            em.merge(obj); // => update and create if not existe

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public AdresseJpa delete(Long id) {
        AdresseJpa adresse = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = MonSingloton.getInstance().getEmf().createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // prevoir ma requete // traitement du resultats
            adresse = em.find(AdresseJpa.class, id);
            em.remove(adresse);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
        }
        return adresse;
    }
}
