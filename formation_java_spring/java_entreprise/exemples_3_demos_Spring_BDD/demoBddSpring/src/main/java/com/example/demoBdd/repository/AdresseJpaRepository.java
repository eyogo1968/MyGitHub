package com.example.demoBdd.repository;

import com.example.demoBdd.model.AdresseJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface
AdresseJpaRepository extends JpaRepository<AdresseJpa, Long> {
    //CRUD

    List<AdresseJpa> findByVille(String ville);

    List<AdresseJpa> findByRueAndCodePostal(String rue, String codePostal);

    List<AdresseJpa> findByVilleOrCodePostal(String ville, String codePostal);

    //@Query("select c.adresse from CLIENT c where c.id_client = :ma_variable")
    //AdresseJpa findByClient(@Param("ma_variable") Long id_client);
}
