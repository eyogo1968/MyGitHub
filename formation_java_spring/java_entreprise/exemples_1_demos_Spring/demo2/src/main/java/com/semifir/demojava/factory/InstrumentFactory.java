package com.semifir.demojava.factory;

import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.Guitare;

public class InstrumentFactory {

    public static Instrument getGuitare(){
        return new Guitare();
    }

    public static Instrument getGuitareWithAttributes(String reference,
                                                      String modele,
                                                      Integer numeroSerie){
        return new Guitare(reference, modele,numeroSerie);
    }

}
