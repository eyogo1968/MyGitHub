package com.example.fouille.service;

import com.example.fouille.entity.Archeologue;
import com.example.fouille.entity.Equipe;
import com.example.fouille.repository.EquipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {
    
    private  final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe findById(Long id) {
        Optional<Equipe> optionalEquipe = equipeRepository.findById(id);
        if (optionalEquipe.isPresent()){
            return optionalEquipe.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Equipe create(Equipe item) {
        List<Archeologue> archeologues = item.getMembres();
        boolean isDirected = false;
        for (Archeologue a : archeologues){
            if (a.getDirecteur()){
                isDirected = true;
                break;
            }
        }
        if (! isDirected){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "L'equipe doit OBLIGATOIREMENT avoir un directeur");
        } else {
            return equipeRepository.save(item);
        }
    }

    public void update(Equipe item) {
        if (! equipeRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        equipeRepository.save(item);
    }

    public Equipe delete(Long id) {
        if (!equipeRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Equipe not found");
        }
        Equipe backup = this.findById(id);
        equipeRepository.deleteById(id);
        if (equipeRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }

    public Boolean existById(Long id){
        return this.equipeRepository.existsById(id);
    }
}
