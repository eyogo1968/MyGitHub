package com.semifir.demojava;

import com.semifir.demojava.factory.GuitaristeFactory;
import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.*;

public class Main {

    /*
    On utilise les objets Factory
    On injecte la Guitare dans le Guitariste
    --> Ici on construit quand meme les objets nous meme
    --> l'avantage de SPRING est que on n'a plus besoin de faire tout cela
     */
    public static void injectionDependace(){
        Guitariste gt2 = GuitaristeFactory
                .getGuitaristeWithAttributes("Hendricks", 42,
                        "ref543234", "gibson23098", 333333);

        System.out.println("La guitare joue : "+gt2.getGuitare().jouer());
    }

    public static void main(String[] args){
        System.out.println(" ============== Start projet =========");
        injectionDependace();
    }
}
