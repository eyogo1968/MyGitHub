package fr.aelion.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@ComponentScan
@Scope("prototype")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        //Ajout de Voiture et Moteur en 2 fois avec registrer
        //context.register(Voiture.class);
        //context.register(Moteur.class);
        //Voiture voiture = context.getBean(Voiture.class);

        //Ajout de Voiture et Moteur en 1 fois avec registrer
        //context.register(Voiture.class,Moteur.class);
        //Voiture voiture = context.getBean(Voiture.class);

        //voiture.rouler();

        //context.register(MonBean.class);
        //MonBean monBean1 = context.getBean(MonBean.class);
        //MonBean monBean2 = context.getBean(MonBean.class);
        //monBean1.direBonjour();
        //monBean2.direBonjour();
        //System.out.println(monBean1 == monBean2); // True

        context.register(Pain.class, Steak.class, Salade.class, Fromage.class, Burger.class);
        Burger burger = context.getBean(Burger.class);
    }
}