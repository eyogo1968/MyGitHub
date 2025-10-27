package com.example.fouille.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "objettrouve")
public class ObjetTrouve {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String designation;
    @Column
    private String categorie;
    @Column
    private String completude;
    @Column
    private String etat_conservation;
    @Temporal(TemporalType.DATE)
    @Column
    private Date dateDecouverte;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @ManyToOne
    @JoinColumn(name = "parcelle_id")
    private Parcelle parcelle;

    public ObjetTrouve() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCompletude() {
        return completude;
    }

    public void setCompletude(String completude) {
        this.completude = completude;
    }

    public String getEtat_conservation() {
        return etat_conservation;
    }

    public void setEtat_conservation(String etat_conservation) {
        this.etat_conservation = etat_conservation;
    }

    public Date getDateDecouverte() {
        return dateDecouverte;
    }

    public void setDateDecouverte(Date dateDecouverte) {
        this.dateDecouverte = dateDecouverte;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Parcelle getParcelle() {
        return parcelle;
    }

    public void setParcelle(Parcelle parcelle) {
        this.parcelle = parcelle;
    }
}
