package com.m2i.model;

public interface InteretCalculable {
	
	double calculerInteret();
	
	default void afficherInteret() {
		double interet = calculerInteret();
		System.out.println(formaterInteret(interet));
	}
	
	private String formaterInteret(double interet) {
		return String.format("Interet calcule : %.2f €", interet);
	}
}
