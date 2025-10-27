package com.example.centreformation.entity;

public enum Civilite {
    M("Monsieur"),MME("Madamme"), MLLE("Mademoiselle"),O("Autre");

    private final String label;

    private Civilite(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
