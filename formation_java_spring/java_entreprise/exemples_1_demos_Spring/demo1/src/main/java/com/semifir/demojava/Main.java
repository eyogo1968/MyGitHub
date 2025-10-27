package com.semifir.demojava;

import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.*;

public class Main {

    /*
    On instancie tous les objets manuellement
     */
    public static void manuelInstance(){
        Instrument g1 = new Guitare("ref1234", "gibson4000", 345654);
        System.out.println("La guitare joue : "+g1.jouer());

        /*
        Cas des objets composites.
        Ici on a une mauvaise pratique
        --> Pour construire un Guitariste, il faut construire une Guitare avant
        --> Puis il faudra appeler ce constructeur en lui passant la Guitare creee
        --> Il y a une forte dependance entre l'objet Guitatiste et l'objet Guitare
        --> Imaginez simplement que Guitariste depende fortement de plusieurs autres objets
         */
        Guitariste gt1 = new Guitariste("Michel", 42, g1);
    }

    public static void main(String[] args){
        System.out.println(" ============== Start projet =========");
        manuelInstance();
    }
}
