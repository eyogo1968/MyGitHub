package com.example.centreformation.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypePersonne")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typePersonne"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Formateur.class, name = "F"),
        @JsonSubTypes.Type(value = Stagiaire.class, name = "S")
})
public abstract class Personne {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "civility", length = 15)
    @Enumerated(EnumType.STRING)
    private Civilite civilite;
    @Column(name = "lastname")
    private String nom;
    @Column(name = "firstname")
    private String prenom;
    @Column(name = "mail")
    private String email;
    @OneToOne(fetch = FetchType.EAGER) // default value eager
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adresse adresse;

    public Personne() {
    }
//
//    public Personne(Long id, Civilite civilite, String nom, String prenom, String email, Adresse adresse) {
//        this.id = id;
//        this.civilite = civilite;
//        this.nom = nom;
//        this.prenom = prenom;
//        this.email = email;
//        this.adresse = adresse;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
