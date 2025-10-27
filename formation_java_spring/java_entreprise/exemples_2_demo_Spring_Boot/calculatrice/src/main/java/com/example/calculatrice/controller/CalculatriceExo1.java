package com.example.calculatrice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exo1")
public class CalculatriceExo1 {

    /*
    POST sans body --> @RequestParam
    l'operation et les parametres sont passés dans la requete
    On utilise pas de service
    */

    @PostMapping("/add") //http://localhost:8080/exo1/add?a=33&b=3
    public Integer addition(@RequestParam Integer a , @RequestParam Integer b){
        return a + b;
    }

    @PostMapping("/sub") //http://localhost:8080/exo1/sub?a=33&b=3
    public Integer soustraction(@RequestParam Integer a , @RequestParam Integer b){
        return a - b;
    }

    @PostMapping("/multi") //http://localhost:8080/exo1/multi?a=33&b=3
    public Integer multiplication(@RequestParam Integer a , @RequestParam Integer b){
        return a * b;
    }

    @PostMapping("/div") //http://localhost:8080/exo1/div?a=33&b=3
    public Integer division(@RequestParam Integer a , @RequestParam Integer b){
        if (b != 0){
            return a / b;
        } else {
            return 0;
        }
    }
    @PostMapping("/modulo") //http://localhost:8080/exo1/modulo?a=33&b=3
    public Integer modulo(@RequestParam Integer a , @RequestParam Integer b){
        return a % b;
    }
}
