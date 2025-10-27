package com.semifir.demojava.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// Par defaut le bean est un singleton
// Si on ajoute l'annotation @Scope, il va creer un bean a chaque instanciation
//@Scope("prototype")
public class MonBean {

    private static int compteur = 0;

    public MonBean() {
        compteur++;
        System.out.println("Creation du bean numero "+compteur);
    }

    public void getCompteur(){
        System.out.println("la valeur du compteur est : "+ compteur);
    }

    @PostConstruct
    public void initMethode(){
        System.out.println("Initialisation de mon element");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("before destruction");
    }
}
