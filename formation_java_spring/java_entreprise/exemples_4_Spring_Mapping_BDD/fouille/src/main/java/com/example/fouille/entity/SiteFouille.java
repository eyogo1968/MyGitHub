package com.example.fouille.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sitefouille")
public class SiteFouille {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nomSite;
    @OneToMany(mappedBy = "site")
    private List<Parcelle> parcelles;

    public SiteFouille() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public List<Parcelle> getParcelles() {
        return parcelles;
    }

    public void setParcelles(List<Parcelle> parcelles) {
        this.parcelles = parcelles;
    }
}
