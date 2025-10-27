package com.example.recette.service;

import com.example.recette.entity.Recette;
import com.example.recette.repository.RecetteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecetteService {
    private final RecetteRepository recetteRepository;


    public RecetteService(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }


    public List<Recette> findAll() {
        return recetteRepository.findAll();
    }

    public Recette findById(Integer id) {
//         Optional<Recette> optRecette = this.recetteRepository.findById(id);
//         if (optRecette.isPresent()){
//             return optRecette.get();
//         } else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }
        return recetteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Recette not found"));
    }

    public Recette save(Recette recette) {
        return recetteRepository.save(recette);
    }

    public Recette update(Recette recette) {
        if (recette.getId() != null) {
            recetteRepository.save(recette);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Recette not found");
        }
        return recette;
    }

    public void deleteById(Integer id) {
        if (!recetteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Recette not found");
        }
        recetteRepository.deleteById(id);
        if (recetteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
    }

}
