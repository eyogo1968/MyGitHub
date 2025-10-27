package com.example.centreformation.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue(value = "S")
public class Stagiaire extends Personne{

    @Temporal(TemporalType.DATE)
    @Column(name = "bithdate")
    private Date dtNaissance;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    public Stagiaire() {
    }

    public Date getDtNaissance() {
        return dtNaissance;
    }

    public void setDtNaissance(Date dtNaissance) {
        this.dtNaissance = dtNaissance;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
}
