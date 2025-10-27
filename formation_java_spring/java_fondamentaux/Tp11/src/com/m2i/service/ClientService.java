// com.m2i.service.ClientService.java
package com.m2i.service;

import com.m2i.model.Client;
import java.util.List;
import java.util.Optional;

public class ClientService {
    private static List<Client> clients;

    public static Optional<Client> rechercherClientParId(int id) {
        return clients.stream().filter(c -> c.getId() == id).findFirst();
    }
}