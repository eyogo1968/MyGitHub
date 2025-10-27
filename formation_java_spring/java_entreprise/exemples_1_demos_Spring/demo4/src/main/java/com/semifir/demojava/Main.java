package com.semifir.demojava;

import com.semifir.demojava.configs.ApplicationConfiguration;
import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void withApplicationContext(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Pianiste p1 = context.getBean(Pianiste.class);
        System.out.println("Le piano joue : "+p1.getPiano().jouer());
        context.close();

    }

    public static void main(String[] args){
        System.out.println(" ============== Start projet =========");
        withApplicationContext();
    }
}
