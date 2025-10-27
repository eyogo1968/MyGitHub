package com.example.centreformation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adress")
public class Adresse {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "number")
    private Integer numero;
    @Column(name = "street")
    private String rue;
    @Column(name = "complement")
    private String complement;
    @Column(name = "zipcode")
    private String codePostal;
    @Column(name = "city")
    private String ville;
    @Column(name = "country")
    private String pays;

    public Adresse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
