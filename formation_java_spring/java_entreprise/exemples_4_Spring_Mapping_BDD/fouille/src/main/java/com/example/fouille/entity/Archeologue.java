package com.example.fouille.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "archeologue")
public class Archeologue {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private Boolean isDirecteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    public Archeologue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Boolean getDirecteur() {
        return isDirecteur;
    }

    public void setDirecteur(Boolean directeur) {
        isDirecteur = directeur;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
