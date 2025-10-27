package com.example.recette.controller;

import com.example.recette.entity.Recette;
import com.example.recette.service.RecetteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/recettes")
public class RecetteController {
    private final RecetteService recetteService;

    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("/")
    public List<Recette> findAll() {
        return recetteService.findAll();
    }

    @GetMapping("/{id}")
    public Recette findById(@PathVariable Integer id) {
        return recetteService.findById(id);
    }

    @PostMapping("/")
    public Recette save(@RequestBody Recette recette) {
        return recetteService.save(recette);
    }

    @PutMapping("/{id}")
    public Recette update(@PathVariable Integer id, @RequestBody Recette recette) {
        if (recette.getId().equals(id)){
            return recetteService.update(recette);
        } else {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Path id : "+id+" and recette id : "+recette+ " not valid");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        recetteService.deleteById(id);
    }
}
