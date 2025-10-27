package com.example.centreformation.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "subject")
public class Matiere {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", length = 100)
    private String nom;
    @Column(name = "duration")
    private Integer duree;
    @Column(name = "difficulty", length = 25)
    @Enumerated(EnumType.STRING)
    private Difficulte difficulte;

    @Temporal(TemporalType.DATE)
    @Column
    private Date miseajour;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "competences")
    private List<Formateur> formateurs = new ArrayList<>();

    public Matiere() {
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

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

    public Date getMiseajour() {
        return miseajour;
    }

    public void setMiseajour(Date miseajour) {
        this.miseajour = miseajour;
    }
}
