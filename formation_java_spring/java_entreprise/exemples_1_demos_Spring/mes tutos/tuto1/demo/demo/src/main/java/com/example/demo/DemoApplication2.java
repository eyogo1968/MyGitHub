package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication2.class, args);
	}

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/tuto1/get/objet/hello")
	public Hello hello(@RequestParam(value = "content", defaultValue = "World") String content) {
		/*
		  Ici, on n'a pas de controller
		  on retourne un objet Hello --> Hello ayant deux attributs --> (long id, String content)
          Comme on est en REST --> Sping va mapper cet objet Hello dans un JSON {"id": 1,"content": "Hello, World!"}

		  l'annotation @GetMapping indique a Spring que :
		  ---> l'url "/tuto1/get/objet/hello est mappée sur la méthode hello(long id, String content)

		  l'annotation @RequestParam(value = "name", defaultValue = "World") indique a Spring que :
		  ---> le parametre "name" prendra la veleur "World" si on ne le renseigne pas dans la requete HTTP

		  on peut donc lancer les deux requetes suivantes :
		  ---> http://localhost:8080/tuto1/get/objet/hello
		  ---> http://localhost:8080/tuto1/get/objet/hello?content=toto
		 */
		return new Hello(counter.incrementAndGet(), String.format(template, content));
	}
}
