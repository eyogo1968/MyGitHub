package com.example.centreformation.service;

import com.example.centreformation.entity.Formateur;
import com.example.centreformation.repository.PersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {

    private final PersonneRepository personneRepository;

    public FormateurService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Formateur> findAllFormateur(){
        return personneRepository.findAllFormateur();
    }
}
