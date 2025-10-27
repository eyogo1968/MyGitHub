package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication1.class, args);
	}

	@GetMapping("/tuto1/get/text/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		/*
		  Ici, on n'a pas de controller
		  on retourne simplement une chaine de caracteres de type String --> "Hello %s!", name

		  l'annotation @GetMapping indique a Spring que :
		  ---> l'url "/tuto1/get/text/hello est mappée sur la méthode hello(String name)

		  l'annotation @RequestParam(value = "name", defaultValue = "World") indique a Spring que :
		  ---> le parametre "name" prendra la veleur "World" si on ne le renseigne pas dans la requete HTTP

		  on peut donc lancer les deux requetes suivantes :
		  ---> http://localhost:8080/tuto1/get/text/hello
		  ---> http://localhost:8080/tuto1/get/text/hello?name=toto
		 */
		return String.format("Hello %s!", name);
	}
}
