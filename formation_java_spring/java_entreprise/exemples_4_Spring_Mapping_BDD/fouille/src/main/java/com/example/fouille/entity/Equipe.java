package com.example.fouille.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "equipe")
    private List<Archeologue> membres;

    @OneToMany
    @JoinTable(
            name = "fouille",
            joinColumns = @JoinColumn(name = "equipeId"),
            inverseJoinColumns = @JoinColumn(name = "parcelle_id")
    )
    private List<Fouille> fouilles;

    public Equipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Archeologue> getMembres() {
        return membres;
    }

    public void setMembres(List<Archeologue> membres) {
        this.membres = membres;
    }

    public List<Fouille> getFouilles() {
        return fouilles;
    }

    public void setFouilles(List<Fouille> fouilles) {
        this.fouilles = fouilles;
    }
}
