package com.example.recette.service;

import com.example.recette.entity.IngredientQuantite;
import com.example.recette.repository.IngredientQuantiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IngredientQuantiteService {
    private final IngredientQuantiteRepository ingredientQuantiteRepository;


    public IngredientQuantiteService(IngredientQuantiteRepository ingredientQuantiteRepository) {
        this.ingredientQuantiteRepository = ingredientQuantiteRepository;
    }


    public List<IngredientQuantite> findAll() {
        return ingredientQuantiteRepository.findAll();
    }

    public IngredientQuantite findById(Integer id) {
//         Optional<IngredientQuantite> optIngredientQuantite = this.ingredientQuantiteRepository.findById(id);
//         if (optIngredientQuantite.isPresent()){
//             return optIngredientQuantite.get();
//         } else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }
        return ingredientQuantiteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "IngredientQuantite not found"));
    }

    public IngredientQuantite save(IngredientQuantite ingredientQuantite) {
        return ingredientQuantiteRepository.save(ingredientQuantite);
    }

    public IngredientQuantite update(IngredientQuantite ingredientQuantite) {
        if (ingredientQuantite.getId() != null) {
            ingredientQuantiteRepository.save(ingredientQuantite);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "IngredientQuantite not found");
        }
        return ingredientQuantite;
    }

    public void deleteById(Integer id) {
        if (!ingredientQuantiteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "IngredientQuantite not found");
        }
        ingredientQuantiteRepository.deleteById(id);
        if (ingredientQuantiteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
    }
}
