package com.example.demoboot.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /*
     Le controller recoit et valide la requete puis il la transmet au service
     Le service recoit une requete et fait de l'algo pour satisfaire les specifications
     Le service va contruire une reponse et la renvoyer au controller. Le service demande
     au repository de persister les donnees ou le recuperer ---> correspond au SSI
     */
    @GetMapping("/index") // http://localhost:8090/index
    public String index(){
        return "Server online !";
    }

    @GetMapping("/index/{info}") // http://localhost:8090/index/information_recuperee
    public String index2(@PathVariable("info") String info ){
        return "Recuperation dans l'url de : "+ info;
    }

    @GetMapping("/index/param") // http://localhost:8090/index/param?cle=toto ou http://localhost:8090/index/param
    public String index3(@RequestParam(defaultValue = "aucune") String cle){
        return "Param recupéré : "+ cle;
    }

    @GetMapping("/index/param2") // http://localhost:8090/index/param2 --> pas de parametres ---> null
    public String index4(@RequestParam(required = false) String cle){
        return "Param recupéré : "+ cle; // valeur null
    }

    @GetMapping("/index/param3") // http://localhost:8090/index/param3?cle=toto
    public ResponseEntity<String> index5(@RequestParam(required = false) String cle){
        HttpHeaders headers = new HttpHeaders();
        headers.add("mon_custom_headers", "custom value");
        return new ResponseEntity<>(
                "Param recupéré : "+ cle, // valeur null
                headers,
                HttpStatus.CONTINUE
        );
    }
}
