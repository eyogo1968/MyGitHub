package com.semifir.demojava.model;

import com.semifir.demojava.interfaces.Instrument;

public class Guitare implements Instrument {

    // attributs
    private String reference;
    private String modele;
    private Integer numeroSerie;

    // constructeur(s)
    public Guitare() {
    }

    public Guitare(String reference, String modele, Integer numeroSerie) {
        this.reference = reference;
        this.modele = modele;
        this.numeroSerie = numeroSerie;
    }

    // GETTER SETTER
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Integer numeroSerie) throws Exception {
        if (numeroSerie > 0){
            this.numeroSerie = numeroSerie;
        } else {
           throw new Exception("illegal argument : doit etre positif");
        }
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    //methodes
    public String jouer(){
        return "glingglinglin";
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Guitare{");
        sb.append("reference='").append(reference).append('\'');
        sb.append(", modele='").append(modele).append('\'');
        sb.append(", numeroSerie=").append(numeroSerie);
        sb.append('}');
        return sb.toString();
    }
}
