package com.example.recette.service;

import com.example.recette.entity.Ingredient;
import com.example.recette.repository.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;


    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient findById(Integer id) {
//         Optional<Ingredient> optIngredient = this.ingredientRepository.findById(id);
//         if (optIngredient.isPresent()){
//             return optIngredient.get();
//         } else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }
        return ingredientRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ingredient not found"));
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient update(Ingredient ingredient) {
        if (ingredient.getId() != null) {
            ingredientRepository.save(ingredient);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Ingredient not found");
        }
        return ingredient;
    }

    public void deleteById(Integer id) {
        if (!ingredientRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Ingredient not found");
        }
        ingredientRepository.deleteById(id);
        if (ingredientRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
    }

}
