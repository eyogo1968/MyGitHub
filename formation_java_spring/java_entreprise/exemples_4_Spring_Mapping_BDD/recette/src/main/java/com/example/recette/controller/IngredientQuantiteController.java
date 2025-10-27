package com.example.recette.controller;

import com.example.recette.entity.IngredientQuantite;
import com.example.recette.service.IngredientQuantiteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/ingredientQuantities")
public class IngredientQuantiteController {
    private final IngredientQuantiteService ingredientQuantiteService;

    public IngredientQuantiteController(IngredientQuantiteService ingredientQuantiteService) {
        this.ingredientQuantiteService = ingredientQuantiteService;
    }

    @GetMapping("/")
    public List<IngredientQuantite> findAll() {
        return ingredientQuantiteService.findAll();
    }

    @GetMapping("/{id}")
    public IngredientQuantite findById(@PathVariable Integer id) {
        return ingredientQuantiteService.findById(id);
    }

    @PostMapping("/")
    public IngredientQuantite save(@RequestBody IngredientQuantite ingredientQuantite) {
        return ingredientQuantiteService.save(ingredientQuantite);
    }

    @PutMapping("/{id}")
    public IngredientQuantite update(@PathVariable Integer id, @RequestBody IngredientQuantite ingredientQuantite) {
        if (ingredientQuantite.getId().equals(id)){
            return ingredientQuantiteService.update(ingredientQuantite);
        } else {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Path id : "+id+" and ingredientQuantite id : "+ingredientQuantite+ " not valid");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ingredientQuantiteService.deleteById(id);
    }
}
