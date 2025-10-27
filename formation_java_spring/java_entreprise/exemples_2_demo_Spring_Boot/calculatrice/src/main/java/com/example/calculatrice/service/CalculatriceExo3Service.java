package com.example.calculatrice.service;

import com.example.calculatrice.model.Calculatrice;
import org.springframework.stereotype.Service;

@Service
public class CalculatriceExo3Service {

    private final CalculatriceExo2Service calculatriceExo2Service;

    public CalculatriceExo3Service(CalculatriceExo2Service calculatriceExo2Service) {
        this.calculatriceExo2Service = calculatriceExo2Service;
    }

    /*
      On recupere le body et on determine l'operation
      On execute l'operation avec les parametres du body
     */
    public Integer calcul(Calculatrice calculatrice){
        return switch (calculatrice.getOperation()){
            case "+" -> calculatriceExo2Service.addition(calculatrice.getNombre1(),
                    calculatrice.getNombre2());
            case "-" -> calculatriceExo2Service.soustraction(calculatrice.getNombre1(),
                    calculatrice.getNombre2());
            case "*" -> calculatriceExo2Service.multiplication(calculatrice.getNombre1(),
                    calculatrice.getNombre2());
            case "/" -> calculatriceExo2Service.division(calculatrice.getNombre1(),
                    calculatrice.getNombre2());
            case "%" -> calculatriceExo2Service.modulo(calculatrice.getNombre1(),
                    calculatrice.getNombre2());
            default -> 0;
        };
    }
}
