package com.example.centreformation.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue(value = "F")
public class Formateur extends Personne {

    @Temporal(TemporalType.DATE)
    @Column(name = "hiredate")
    private Date dtEmbauche;
    @Column(name = "experience")
    private Integer exprience;
    @Column(name = "intern")
    private Boolean interne;

    @OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY)
    private List<Stagiaire> stagiaires = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "skills",
            joinColumns = @JoinColumn(name = "formateur_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Matiere> competences = new ArrayList<>();

    public Formateur() {
    }

//    public Formateur(Long id, Civilite civilite, String nom, String prenom, String email, Adresse adresse, Date dtEmbauche, Integer exprience, Boolean interne) {
//        super(id, civilite, nom, prenom, email, adresse);
//        this.dtEmbauche = dtEmbauche;
//        this.exprience = exprience;
//        this.interne = interne;
//    }

    public Date getDtEmbauche() {
        return dtEmbauche;
    }

    public void setDtEmbauche(Date dtEmbauche) {
        this.dtEmbauche = dtEmbauche;
    }

    public Integer getExprience() {
        return exprience;
    }

    public void setExprience(Integer exprience) {
        this.exprience = exprience;
    }

    public Boolean getInterne() {
        return interne;
    }

    public void setInterne(Boolean interne) {
        this.interne = interne;
    }

    public List<Matiere> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Matiere> competences) {
        this.competences = competences;
    }

    public List<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
    }
}
