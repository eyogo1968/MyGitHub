package com.example.calculatrice.controller;

import com.example.calculatrice.model.Calculatrice;
import com.example.calculatrice.service.CalculatriceExo3Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatriceExo3 {

    private final CalculatriceExo3Service calculatriceExo3Service;

    public CalculatriceExo3(CalculatriceExo3Service calculatriceExo3Service) {
        this.calculatriceExo3Service = calculatriceExo3Service;
    }

    /*
    POST avec body --> @RequestBody
    les parametres sont passés dans le body
    l'operation est precisee dans le body
    le body correspond a l'objet Calculette
    On utilise un service calculatriceExo3Service

    => requete http POST http:///localhost:8080/calcul

    body :
        {
            "operation": "*",
            "nombre1": 33,
            "nombre2": 42
         }
     */

    @PostMapping("/calcul")
    public Integer calcul(@RequestBody Calculatrice calculette){
        return calculatriceExo3Service.calcul(calculette);
    }

}
