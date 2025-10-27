package com.m2i.model;

public class Client {
    private int id;
    private String nom;
    private TypeClient type;
    
    
	public Client(int id, String nom, TypeClient type) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TypeClient getType() {
		return type;
	}
	public void setType(TypeClient type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", type=" + type + "]";
	}

    
}