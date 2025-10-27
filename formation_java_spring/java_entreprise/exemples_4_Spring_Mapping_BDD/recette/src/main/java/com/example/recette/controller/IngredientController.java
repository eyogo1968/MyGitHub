package com.example.recette.controller;

import com.example.recette.entity.Ingredient;
import com.example.recette.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public List<Ingredient> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable Integer id) {
        return ingredientService.findById(id);
    }

    @PostMapping("/")
    public Ingredient save(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient update(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        if (ingredient.getId().equals(id)){
            return ingredientService.update(ingredient);
        } else {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Path id : "+id+" and ingredient id : "+ingredient+ " not valid");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ingredientService.deleteById(id);
    }
}
