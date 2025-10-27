package com.example.fouille.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parcelle")
public class Parcelle {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long numero;
    @Column
    private Integer longueur;
    @Column
    private Integer largeur;
    @ManyToOne
    @JoinColumn(name = "id_site")
    private SiteFouille site;

    @OneToMany
    @JoinTable(
            name = "fouille",
            joinColumns = @JoinColumn(name = "parcelleId"),
            inverseJoinColumns = @JoinColumn(name = "equipeId")
    )
    private List<Fouille> fouilles;

    public Parcelle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Integer getLongueur() {
        return longueur;
    }

    public void setLongueur(Integer longueur) {
        this.longueur = longueur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public SiteFouille getSite() {
        return site;
    }

    public void setSite(SiteFouille site) {
        this.site = site;
    }

    public List<Fouille> getFouilles() {
        return fouilles;
    }

    public void setFouilles(List<Fouille> fouilles) {
        this.fouilles = fouilles;
    }
}
