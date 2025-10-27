package com.semifir.demojava.factory;

import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.Guitariste;

public class GuitaristeFactory {

    public static Guitariste getGuitariste(){
        return new Guitariste();
    }

    public static Guitariste getGuitaristeWithAttributes(String nom,
                                                         Integer age,
                                                         String reference,
                                                         String modele,
                                                         Integer numeroSerie){
        // injection de dependances
        return new Guitariste(
                nom,
                age,
                InstrumentFactory.getGuitareWithAttributes(
                        reference,
                        modele,
                        numeroSerie)
        );
    }
}
