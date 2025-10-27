package com.example.demoboot.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration pour customiser l' affichage su swagger OpenAPI
 * il est accessible à l'adresse : http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI definieOpenApi(){
        Server server = new Server();
        server.setUrl("http://localhost:8090");
        server.setDescription("Server de demo pour les controllers");

        Contact myContact = new Contact();
        myContact.setName("Romain Vasseur");
        myContact.setEmail("your.email@narque.gg");

        Info information = new Info()
                .title("Ma Super App Demo de Controller pour Orsys")
                .version("86.987.765")
                .description("Ceci est un swaggger des points de terminaisons de mon API")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
