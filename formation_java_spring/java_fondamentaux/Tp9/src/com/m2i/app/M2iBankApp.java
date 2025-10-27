package com.m2i.app;

import java.util.Set;
import java.util.stream.Collectors;

import com.m2i.service.Calculateur;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class M2iBankApp {

	public static void afficherComptesUniques(Set<Integer> numerosComptes) {
		for(Integer numeroCompte : numerosComptes) {
			System.out.println("numeroCompte "+ numeroCompte);
		}
	}	
	
	public static void afficherSoldeParCompte(Map<Integer, Double> comptes) {
        Iterator it = comptes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            System.out.println("numero : "+m.getKey()+", solde : "+m.getValue());
        }
	}
	
	public static void afficherComptesSup1000(List<Double> soldes) {
		soldes.stream().filter(s -> s > 1000).forEach(System.out::println);
	}
	
	public static List<String> filtrerClientsParInitiale(List<String> clients, char initiale){
		return clients.stream().filter(s -> s.startsWith(String.valueOf(initiale))).collect(Collectors.toList());		
	}
	
    public static void main(String[] args) {
    	
    	Calculateur calc = new Calculateur() {
    		@Override
    		public int calculer(int a, int b) {
    			return a + b;
    		}
    	};
    	
		System.out.println("Somme = " + calc.calculer(1,2));

    }

}