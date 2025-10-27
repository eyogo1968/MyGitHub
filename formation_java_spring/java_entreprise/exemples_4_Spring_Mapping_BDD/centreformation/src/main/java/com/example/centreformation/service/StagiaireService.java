package com.example.centreformation.service;

import com.example.centreformation.entity.Stagiaire;
import com.example.centreformation.repository.PersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireService {

    private final PersonneRepository personneRepository;

    public StagiaireService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Stagiaire> findAllStagiaire(){
        return personneRepository.findAllStagiaire();
    }
}
