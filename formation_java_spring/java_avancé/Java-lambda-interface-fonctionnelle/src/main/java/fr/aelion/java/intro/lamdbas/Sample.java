package fr.aelion.java.intro.lamdbas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {
    public static void main( String [] args ) {
        sort1();
        sort2();
        sort3();
        sort4();
        myForEach();

        avantLambda1(); // cree une classe anonyme ActionListener et implemente sa methode actionPerformed
        lambda1();

    }

    /*
        Cree une classe anonyme ActionListener
        et implemente sa methode actionPerformed
        qui, prend en entree un objet ActionEvent
     */
    public static void avantLambda1() {
        // Exemple 1
        Button monBouton = new Button("Push me");
        monBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("clic");
            }
        });

        // Exemple 2
        Thread monThread = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Mon traitement ");
            }
        });
        monThread.start();
    }

    /*
        Pas de classe anonyme creee on passe une expresion
        lambda en parametre de la methode cette expression
        lambda est une implementation d'une interface fonctionnelle
   */
    public static void lambda1() {
        // Exemple 1
        Button monBouton = new Button("Push me");
        monBouton.addActionListener(event -> System.out.println("clic"));

        // Exemple 2
        Thread monThread = new Thread(() -> { System.out.println("Mon traitement"); });
        monThread.start();
    }

    public static void sort4() {
        List<String> collection = new ArrayList<>();
        collection.add( "Java" );
        collection.add( "c" );
        collection.add( "Python" );
        collection.add( "C++" );
        collection.add( "ada" );
        collection.add( "lisp" );
        System.out.println(" ");
        System.out.println("*** sort 5 ***");
        System.out.println(" ");
        collection.stream()
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);
    }

    public static void myForEach() {
        List<String> collection = new ArrayList<>();
        collection.add( "Java" );
        collection.add( "c" );
        collection.add( "Python" );
        collection.add( "C++" );
        collection.add( "ada" );
        collection.add( "lisp" );
        System.out.println(" ");
        System.out.println("*** forEach ***");
        System.out.println(" ");
        collection.forEach(System.out::println);
    }

    public static void sort3() {
        List<String> collection = new ArrayList<>();
        collection.add( "Java" );
        collection.add( "c" );
        collection.add( "Python" );
        collection.add( "C++" );
        collection.add( "ada" );
        collection.add( "lisp" );
        System.out.println(" ");
        System.out.println("*** sort 3 ***");
        System.out.println(" ");
        Collections.sort(collection,(s1, s2) ->
                s1.compareToIgnoreCase( s2 )
        );
        for ( String language : collection ) {
            System.out.println(language);
        }
    }

    public static void sort2() {
        List<String> collection = new ArrayList<>();
        collection.add( "Java" );
        collection.add( "c" );
        collection.add( "Python" );
        collection.add( "C++" );
        collection.add( "ada" );
        collection.add( "lisp" );
        System.out.println(" ");
        System.out.println("*** sort 2 ***");
        System.out.println(" ");
        collection.sort( ( String s1, String s2 )  -> {
            return s1.compareToIgnoreCase( s2 );
        } );
        for ( String language : collection ) {
            System.out.println(language);
        }
    }

    public static void sort1() {
        List<String> collection = new ArrayList<>();
        collection.add( "Java" );
        collection.add( "c" );
        collection.add( "Python" );
        collection.add( "C++" );
        collection.add( "ada" );
        collection.add( "lisp" );
        System.out.println(" ");
        System.out.println("*** sort 1 ***");
        System.out.println(" ");
        collection.sort( new Comparator<String>() {
            @Override public int compare( String l1, String l2 ) {
                return l1.compareToIgnoreCase( l2 );
            }
        } );
        for ( String language : collection ) {
            System.out.println(language);
        }
    }
}
