package com.semifir.demojava.model;

import com.semifir.demojava.interfaces.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianiste {

    private String nom;
    @Autowired
    @Qualifier("piano")
    private Instrument piano;

    public Pianiste() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Instrument getPiano() {
        return piano;
    }

    public void setPiano(Instrument piano) {
        this.piano = piano;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pianiste{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", piano=").append(piano);
        sb.append('}');
        return sb.toString();
    }
}
