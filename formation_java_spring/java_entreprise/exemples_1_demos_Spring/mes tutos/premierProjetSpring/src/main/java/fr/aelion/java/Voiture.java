package fr.aelion.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Voiture {
    private Moteur moteur;
    @Autowired
    public Voiture(Moteur moteur) {
        this.moteur = moteur;
    }
    public void rouler() {
        moteur.demarrer();
    }
}
