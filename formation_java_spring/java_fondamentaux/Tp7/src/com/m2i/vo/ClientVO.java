package com.m2i.vo;

public final class ClientVO {
    private final String nom;
    private final String email;
    private final String telephone;

    public ClientVO(String nom, String email, String telephone) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email requis");
        if (!telephone.matches("\\d{10}")) throw new IllegalArgumentException("Téléphone invalide");
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
}