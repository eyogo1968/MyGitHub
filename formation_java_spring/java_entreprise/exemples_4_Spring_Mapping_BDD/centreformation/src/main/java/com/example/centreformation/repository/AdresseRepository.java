package com.example.centreformation.repository;

import com.example.centreformation.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdresseRepository  extends JpaRepository<Adresse, Long> {

    @Query("select p.adresse from Personne p where p.id = :id")
    Adresse findByPersonne(@Param("id") Long id);
}
