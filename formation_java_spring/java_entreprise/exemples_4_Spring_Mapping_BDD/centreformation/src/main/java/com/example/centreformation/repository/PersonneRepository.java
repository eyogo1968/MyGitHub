package com.example.centreformation.repository;

import com.example.centreformation.entity.Formateur;
import com.example.centreformation.entity.Personne;
import com.example.centreformation.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

    @Query("select f from Formateur f")
    List<Formateur> findAllFormateur();

    @Query("select s from Stagiaire s")
    List<Stagiaire> findAllStagiaire();

    Optional<Personne> findByEmail(@Param("email") String email);
}
