package com.example.centreformation.service;

import com.example.centreformation.entity.Personne;
import com.example.centreformation.repository.PersonneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService implements CrudService<Personne,Long> {
    
    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }


    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne findById(Long id) {
        Optional<Personne> optionalPersonne = personneRepository.findById(id);
        if (optionalPersonne.isPresent()){
            return optionalPersonne.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Personne create(Personne item) {
        return personneRepository.save(item);
    }

    @Override
    public void update(Personne item) {
        if (! personneRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        personneRepository.save(item);
    }

    @Override
    public Personne delete(Long id) {
        if (!personneRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Person not found");
        }
        Personne backup = this.findById(id);
        personneRepository.deleteById(id);
        if (personneRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }

    public  Personne findByEmail(String email){
        Optional<Personne> optionalPersonne = this.personneRepository.findByEmail(email);
        if (optionalPersonne.isPresent()){
            return optionalPersonne.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Personne findByEmailManuel(String email){
        List<Personne> personnes = this.findAll();
        for (Personne p : personnes){
            if (p.getEmail().equals(email)){
                return p;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
