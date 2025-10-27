package com.example.centreformation.service;

import com.example.centreformation.entity.Adresse;
import com.example.centreformation.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService implements CrudService<Adresse, Long> {

    @Autowired
    private AdresseRepository adresseRepository;


    @Override
    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }

    @Override
    public Adresse findById(Long id) {
        Optional<Adresse> optionalAdresse = adresseRepository.findById(id);
        if (optionalAdresse.isPresent()){
            return optionalAdresse.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Adresse findByPersonne(Long id){
        return this.adresseRepository.findByPersonne(id);
    }

    @Override
    public Adresse create(Adresse item) {
        return adresseRepository.save(item);
    }

    @Override
    public void update(Adresse item) {
        if (! adresseRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        adresseRepository.save(item);
    }

    @Override
    public Adresse delete(Long id) {
        if (!adresseRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Adress not found");
        }
        Adresse backup = this.findById(id);
        adresseRepository.deleteById(id);
        if (adresseRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }
}
