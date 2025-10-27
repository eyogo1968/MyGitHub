package com.example.calculatrice.controller;

import com.example.calculatrice.service.CalculatriceExo2Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exo2")
public class CalculatriceExo2 {
    /*
    POST sans body --> @RequestParam
    l'operation et les parametres sont passés dans la requete
    On utilise un service CalculatriceExo2Service
    */
    private final CalculatriceExo2Service calculatriceExo2Service;

    public CalculatriceExo2(CalculatriceExo2Service calculatriceExo2Service) {
        this.calculatriceExo2Service = calculatriceExo2Service;
    }

    /*
    POST sans body --> @RequestParam
    les parametres sont passés dans la requete
    l'operation est precisee dans la requete
    */

    @PostMapping("/add") // http://localhost:8080/exo2/add?a=33&b=3
    public Integer addition(@RequestParam Integer a , @RequestParam Integer b){
        return calculatriceExo2Service.addition(a,b);
    }

    @PostMapping("/sub") // http://localhost:8080/exo2/sub?a=33&b=3
    public Integer soustraction(@RequestParam Integer a , @RequestParam Integer b){
        return calculatriceExo2Service.soustraction(a,b);
    }

    @PostMapping("/multi") // http://localhost:8080/exo2/multi?a=33&b=3
    public Integer multiplication(@RequestParam Integer a , @RequestParam Integer b){
        return calculatriceExo2Service.multiplication(a,b);
    }

    @PostMapping("/div") // http://localhost:8080/exo2/div?a=33&b=3
    public Integer division(@RequestParam Integer a , @RequestParam Integer b){
        return calculatriceExo2Service.division(a,b);
    }

    @PostMapping("/modulo") // http://localhost:8080/exo2/modulo?a=33&b=3
    public Integer modulo(@RequestParam Integer a , @RequestParam Integer b){
        return calculatriceExo2Service.modulo(a,b);
    }
}
