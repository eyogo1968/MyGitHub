package fr.aelion.java;

import org.springframework.stereotype.Component;

@Component
public class MonBean {
    private static int compteur = 0;
    public MonBean() {
        compteur++;
        System.out.println("Création du bean n°" + compteur);
    }
    public void direBonjour() {
        System.out.println("Bonjour "+ compteur);
    }
}
