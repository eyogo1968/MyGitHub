package fr.aelion.java;

import org.springframework.stereotype.Component;

@Component
public class Burger {
    public Pain pain;
    public Steak steak;
    public Salade salade;
    public Fromage fromage;

    public Burger(Pain pain,Steak steak,Salade salade,Fromage fromage){
        this.pain = pain;
        this.steak = steak;
        this.salade = salade;
        this.fromage = fromage;
    }
}
