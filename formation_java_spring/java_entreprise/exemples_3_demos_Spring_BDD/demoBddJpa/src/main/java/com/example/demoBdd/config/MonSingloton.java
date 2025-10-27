package com.example.demoBdd.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class Singloton qui ne peut s'instéancier qu'une seule fois
 */
public class MonSingloton {

    // varialbe static pour stocker l'unique instance
    private static MonSingloton instance = null;
    // variable de connection
    private Connection connection;
    private String url;
    private String username;
    private String password;

    // ??????
    private final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("ma-persistence-unit");

    public EntityManagerFactory getEmf(){
        return emf;
    }

    // bloquer l'instanciation externe
    private MonSingloton() {
    }

    // methode static d'instanciation
    public static MonSingloton getInstance(){
        // création si il existe pas
        if (instance == null){
            instance = new MonSingloton();
        }
        // sinon recuperation
        return instance;
    }

    private void ajoutInfoConnection(){
        this.url = "jdbc:mysql://localhost:3306/orsys07";
        this.username = "root";
        this.password = "root";
    }

    public Connection getConnection() throws SQLException {
        // charger le bon driver jbdc
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // information de connection
        ajoutInfoConnection();
        // creation de la connection
        this.connection = DriverManager.getConnection(
                this.url,
                this.username,
                this.password
        );
        return connection;
    }


}
