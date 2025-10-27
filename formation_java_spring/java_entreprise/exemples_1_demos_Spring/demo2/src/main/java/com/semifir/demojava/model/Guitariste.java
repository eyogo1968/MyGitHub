package com.semifir.demojava.model;

import com.semifir.demojava.interfaces.Instrument;

public class Guitariste {

    private String nom;
    private Integer age;
    private Instrument guitare;

    public Guitariste() {
    }

    /*
    Injection des dependances
    On injecte un objet Guitare dans l'objet Guitariste
     */
    public Guitariste(String nom, Integer age, Instrument guitare) {
        this.nom = nom;
        this.age = age;
        this.guitare = guitare;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Instrument getGuitare() {
        return guitare;
    }

    public void setGuitare(Instrument guitare) {
        this.guitare = guitare;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Guitariste{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", age=").append(age);
        sb.append(", guitare=").append(guitare);
        sb.append('}');
        return sb.toString();
    }
}
