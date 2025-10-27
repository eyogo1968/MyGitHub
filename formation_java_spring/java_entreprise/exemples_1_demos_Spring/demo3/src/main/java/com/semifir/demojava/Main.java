package com.semifir.demojava;

import com.semifir.demojava.configs.ApplicationConfiguration;
import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void withApplicationContext(){
        // On charge le context
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        // On recupere le bean par la classe
        Instrument cornemuse = context.getBean(Cornemuse.class);
        Guitariste guitariste = context.getBean(Guitariste.class);

        // On recupere le bean par le nom du bean
        //Instrument cornemuse = (Instrument) context.getBean("cornemuse");
        //Guitariste guitariste = (Guitariste) context.getBean("guitariste");

        System.out.println("La guitare joue : "+guitariste.getGuitare().jouer());
        System.out.println("La cornemuse joue : "+cornemuse.jouer());

        context.close();
    }

    public static void main(String[] args){
        System.out.println(" ============== Start projet =========");
        withApplicationContext();
    }
}
