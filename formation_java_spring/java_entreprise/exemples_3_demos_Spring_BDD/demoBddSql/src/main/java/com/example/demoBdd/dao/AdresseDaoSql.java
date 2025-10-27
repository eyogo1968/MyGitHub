package com.example.demoBdd.dao;

import com.example.demoBdd.config.MonSingloton;
import com.example.demoBdd.model.AdresseSql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresseDaoSql {

    public List<AdresseSql> getAll() {
        List<AdresseSql> adresses = new ArrayList<>();
        Connection connection = null;

        try {
            connection = MonSingloton.getInstance().getConnection();
            // prevoir ma requete
            PreparedStatement ps = connection
                    .prepareStatement("SELECT ID,RUE,VILLE,CODEPOSTAL,PAYS FROM ADRESSE");

            // execution de la requete
            ResultSet rs = ps.executeQuery();

            // traitement du resultats
            while(rs.next()){
                Long id = rs.getLong("ID");
                String rue = rs.getString("RUE");
                String ville = rs.getString("VILLE");
                String codePostal = rs.getString("CODEPOSTAL");
                String pays = rs.getString("PAYS");

                AdresseSql adresse = new AdresseSql(id, rue, ville, codePostal, pays);

                adresses.add(adresse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }

        return adresses;
    }

    public AdresseSql getById(Long id) {
        AdresseSql adresse = null;
        Connection connection = null;

        try {
            connection = MonSingloton.getInstance().getConnection();
            // prevoir ma requete
            PreparedStatement ps = connection
                    .prepareStatement("SELECT RUE,VILLE,CODEPOSTAL,PAYS FROM ADRESSE WHERE ID = ?");

            // le numero de la variable à injecter dans l'ordre et commence à 1
            ps.setLong(1, id);
            // execution de la requete
            ResultSet rs = ps.executeQuery();

            // traitement du resultats
            if(rs.next()){
                String rue = rs.getString("RUE");
                String ville = rs.getString("VILLE");
                String codePostal = rs.getString("CODEPOSTAL");
                String pays = rs.getString("PAYS");

               adresse = new AdresseSql(id, rue, ville, codePostal, pays);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }

        return adresse;
    }

    public AdresseSql create(AdresseSql obj) {
        Connection connection = null;

        try {
            connection = MonSingloton.getInstance().getConnection();
            // prevoir ma requete
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO ADRESSE (RUE,VILLE,CODEPOSTAL,PAYS) VALUES(?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);

            // le numero de la variable à injecter dans l'ordre et commence à 1
            ps.setString(1, obj.getRue());
            ps.setString(2, obj.getVille());
            ps.setString(3, obj.getCodePostal());
            ps.setString(4, obj.getPays());

            // execution de la requete
            int rows = ps.executeUpdate();

            // traitement du resultats
            if(rows != 1){
                throw new SQLException("Probleme à l'insertion de "+obj.toString());
            }else {
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()){
                    Long id = keys.getLong(1);
                    obj.setId(id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return obj;
    }

    public void update(AdresseSql obj) {
        Connection connection = null;

        try {
            connection = MonSingloton.getInstance().getConnection();
            // prevoir ma requete
            PreparedStatement ps = connection
                    .prepareStatement("UPDATE ADRESSE SET RUE = ?, VILLE = ?, CODEPOSTAL = ?, PAYS = ? WHERE ID = ?");

            // le numero de la variable à injecter dans l'ordre et commence à 1
            ps.setString(1, obj.getRue());
            ps.setString(2, obj.getVille());
            ps.setString(3, obj.getCodePostal());
            ps.setString(4, obj.getPays());
            ps.setLong(5, obj.getId());

            // execution de la requete
            int rows = ps.executeUpdate();

            // traitement du resultats
            if(rows != 1){
                throw new SQLException("Probleme à la mise à jour de "+obj.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public AdresseSql delete(Long id) {
        AdresseSql supressedAdresse = getById(id);
        Connection connection = null;

        try {
            connection = MonSingloton.getInstance().getConnection();
            // prevoir ma requete
            PreparedStatement ps = connection
                    .prepareStatement("DELETE FROM ADRESSE WHERE ID = ?");

            // le numero de la variable à injecter dans l'ordre et commence à 1
            ps.setLong(1, id);

            // execution de la requete
            int rows = ps.executeUpdate();

            // traitement du resultats
            if(rows != 1){
                throw new SQLException("Probleme à la supression de "+id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return supressedAdresse;
    }
}
