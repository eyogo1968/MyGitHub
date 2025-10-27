package com.semifir.demojava;

import com.semifir.demojava.configs.ApplicationConfiguration;
import com.semifir.demojava.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void beanContext() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MonBean monbean1 = (MonBean)context.getBean(MonBean.class);
        MonBean monbean2 = context.getBean(MonBean.class);
        monbean1.getCompteur();
        monbean2.getCompteur();
    }

    public static void main(String[] args){
        System.out.println(" ============== Start projet =========");
        beanContext();
    }
}
